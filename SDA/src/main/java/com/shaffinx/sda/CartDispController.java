/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import com.shaffinx.sda.Cart.Cart;
import com.shaffinx.sda.Cart.CartSingleton;
import com.shaffinx.sda.Browse.pdisp;
import java.util.ArrayList;
import java.io.IOException;
import javafx.scene.control.Label;
public class CartDispController {
    @FXML
    private Label msg;
    @FXML
    private GridPane cartitems;
    @FXML
    public void initialize(){
        
        Cart cart = CartSingleton.getInstance();
        ArrayList<pdisp> items = cart.getCart();
        int column = 0;
        int row = 0;
        
        Label name= new Label();
        Label pric= new Label();
        for (int i=0;i<items.size();i++) {
            name.setText(items.get(i).name);
            name.setStyle("-fx-font-weight:bold;-fx-font-size:14;");
            pric.setText("$ "+items.get(i).price);
            pric.setStyle("-fx-font-weight:bold;-fx-font-size:14;");
            cartitems.add(name, column++, row);
            cartitems.add(pric, column++, row);
            cartitems.setStyle("-fx-border-color:  #F2F0EA; -fx-padding: 10; -fx-background-color:  #F2F0EA; -fx-background-radius: 20;-fx-border-radius:20;");
            column = 0;
            row++;
        }
    }
    @FXML
    private void GoBack() throws IOException{
        App.setRoot("Home");
    }
    @FXML
    private void Order() throws IOException{
        Cart cart = CartSingleton.getInstance();
        cart.delete();
        msg.setText("Order Completed");
        try {
            // Sleep for 2 seconds (2000 milliseconds)
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Handle the exception if the thread is interrupted
            System.err.println("Sleep was interrupted: " + e.getMessage());
        }
        App.setRoot("Home");
    }
    
}
