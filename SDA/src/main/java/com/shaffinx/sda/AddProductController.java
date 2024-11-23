/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Spinner;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.SpinnerValueFactory;

import com.shaffinx.sda.Session.Session;
import java.sql.ResultSet;
import com.shaffinx.sda.Session.SessionSingelton;
import com.shaffinx.sda.ManageProducts.ProductController;
import com.shaffinx.sda.ManageProducts.Product;
import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.DBFactory.ExecSingleton;

import java.sql.SQLException;
import java.io.IOException;


public class AddProductController {
    private String URL="";
    @FXML
    private ImageView imageView;
    @FXML
    private Label err;
    @FXML
    private TextField pname;
    @FXML
    private TextArea descr;
    @FXML
    private Spinner<Integer> price;
    @FXML
    private void initialize() {
        price.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 999999, 0));
    }
    @FXML
    private void handleImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif"));

        // Show the open file dialog
        Stage stage = (Stage) imageView.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            // Create an Image object from the selected file
            Image image = new Image(file.toURI().toString());
            URL = image.getUrl().substring(6);
            // Set the image to the ImageView
            imageView.setImage(image);
            
        }
    }
    private int GETSTRID() throws SQLException{
        Session sess = SessionSingelton.getInstance();
        exec EXE = ExecSingleton.getInstance();
        ResultSet alpha=EXE.Get("Select storeid from store where id = "+sess.id+" AND stname = '"+sess.storename+"'");
        alpha.next();
        int res = alpha.getInt("storeid");
        return res;
    }
    @FXML
    private void Upload() throws SQLException
    {
        
      if(pname.getText()!=""&&descr.getText()!=""&&price.getValue()!=0&&URL!=""){
        int stid = GETSTRID();
        Product prod = new Product(pname.getText(),descr.getText(),URL,stid,price.getValue());
        ProductController executeADD = new ProductController();
        if(executeADD.Create(prod)){
            err.setText("Product Added Successfully");
        }
        else{
            err.setText("Error Occurred!");
        }
      }
      else{
          err.setText("Please Fill all Fields!");
      }
    }
    
    @FXML
    private void GoBack() throws IOException{
        App.setRoot("ProfileS");
    }
    
}
