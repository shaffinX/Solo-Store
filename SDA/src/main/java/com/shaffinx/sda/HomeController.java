/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import java.sql.ResultSet;
import com.shaffinx.sda.Browse.ProdSingleton;
import java.sql.SQLException;
import java.io.ByteArrayInputStream;
import com.shaffinx.sda.Browse.pdisp;
public class HomeController{


    @FXML
    private void Account(MouseEvent event)throws IOException {
        Session s = SessionSingelton.getInstance();
        if("customer".equals(s.role)){
            App.setRoot("ProfileC");
        }
        if("store".equals(s.role)){
            App.setRoot("ProfileS");
        }
         
    }
    @FXML
    private void Cart(MouseEvent event) {
        System.out.println("Cart");
    }
    
    @FXML
    private GridPane productDisplay;
    @FXML
    public void initialize(){
        
        exec Exe = ExecSingleton.getInstance();
        try{
            ResultSet data=Exe.Get("select * from products");
            ArrayList<pdisp> products = new ArrayList<pdisp>();
            pdisp temp = new pdisp();
            while(data.next()){
                temp.name=data.getString("prodname");
                temp.img = data.getBytes("img");
                temp.pid = data.getInt("prodid");
                temp.price = data.getInt("price");
                temp.desc = data.getString("pdesc");
                temp.stid = data.getInt("storeid");
                products.add(temp);
            }
            map(products);
        }
        catch(SQLException e){
            System.err.println("An SQL exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
    private void map(ArrayList<pdisp> prod){
        int column = 0;
        int row = 0;

        for (int i=0;i<prod.size();i++) {
            VBox productBox = createProductBox(prod.get(i));
            productDisplay.add(productBox, column++, row);

            // Move to the next row after 3 columns
            if (column == 4) {
                column = 0;
                row++;
            }
        }
    }
    private VBox createProductBox(pdisp prod){
        
        ByteArrayInputStream inputStream = new ByteArrayInputStream(prod.img);
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);
        Label label = new Label(prod.name);
        Label prc = new Label("$ "+prod.price);

        VBox box = new VBox(10, imageView, label,prc);
        box.setStyle("-fx-font-weight:bold;-fx-font-size:14; -fx-border-color:  #F2F0EA; -fx-padding: 10; -fx-background-color:  #F2F0EA; -fx-background-radius: 20;-fx-border-radius:20;-fx-cursor: hand");

        box.setOnMouseClicked(event -> nextPage(prod));
        return box;
    }
    
    private void nextPage(pdisp prod){
        try{
            pdisp save=ProdSingleton.getInstance();
            save.desc = prod.desc;
            save.name = prod.name;
            save.img = prod.img;
            save.pid = prod.pid;
            save.price=prod.price;
            save.stid=prod.stid;
            if(save.img.length>0){
                App.setRoot("ProductDetails");
            }
            else{
                System.out.println("F");
            }
        }
        catch(IOException e){
            System.err.println("An SQL exception occurred: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
    
    @FXML
    private void GotoCart()throws IOException{
        App.setRoot("CartDisp");
    }
}