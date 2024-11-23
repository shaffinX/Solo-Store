/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import java.sql.ResultSet;
import com.shaffinx.sda.ManageProducts.ProductController;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.ManageProducts.Product;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import java.io.IOException;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;


public class UpdateProductController{
    private ResultSet Data;
    
    @FXML
    private TableView<ProductModel> display;
    @FXML
    private TableColumn<ProductModel, String> prod_id;
    @FXML
    private TableColumn<ProductModel, String> name;
    @FXML
    private TableColumn<ProductModel, String> description;
    @FXML
    private TableColumn<ProductModel, String> price;
    
    private ObservableList<ProductModel> list = FXCollections.observableArrayList();
    
    
    @FXML
    private TextField pname;
    @FXML
    private TextArea descr;
    @FXML
    private Spinner<Integer> prc;
    @FXML
    private Spinner<Integer> id;
    @FXML
    private Label err;
    
    private int GETSTRID() throws SQLException{
        Session sess = SessionSingelton.getInstance();
        exec EXE = ExecSingleton.getInstance();
        ResultSet alpha=EXE.Get("Select storeid from store where id = "+sess.id+" AND stname = '"+sess.storename+"'");
        alpha.next();
        int res = alpha.getInt("storeid");
        return res;
    }
    
    @FXML
    public void initialize() throws SQLException{
        prc.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 999999, 0));
        id.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 999999, 0));
        
        prod_id.setCellValueFactory(new PropertyValueFactory<>("prod_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        int stid= GETSTRID();
        ProductController alpha = new ProductController();
        Data = alpha.Read(stid);

        while(Data.next()){
            list.add(new ProductModel(
                Data.getInt("prodid"),
                Data.getString("prodname"),
                Data.getString("pdesc"),
                Data.getInt("price")
            ));
        }
        display.setItems(list);
        
    }
    @FXML
    private void UpdateProd()throws SQLException
    {
        if(pname.getText()!=""&&descr.getText()!=""&&prc.getValue()!=0&&id.getValue()!=0){
        int stid = GETSTRID();
        Product prod = new Product(pname.getText(),descr.getText(),"",stid,prc.getValue());
        ProductController executeUP = new ProductController();
        if(executeUP.Update(prod,stid,id.getValue())){
            err.setText("Product Updated Successfully");
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
    private void Refresh()throws SQLException
    {
        list.clear();
        initialize();
    }
    @FXML
    private void GoBack() throws IOException{
        App.setRoot("ProfileS");
    }
    
}
