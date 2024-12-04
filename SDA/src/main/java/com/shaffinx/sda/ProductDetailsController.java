/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.Browse.pdisp;
import javafx.fxml.FXML;
import com.shaffinx.sda.Browse.ProdSingleton;
import java.io.ByteArrayInputStream;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import com.shaffinx.sda.Cart.Cart;
import com.shaffinx.sda.Cart.CartSingleton;

public class ProductDetailsController {
    @FXML
    private Label name;
    @FXML
    private Label prc;
    @FXML
    private Label desc;
    @FXML
    private ImageView img;
    private pdisp details;
    @FXML
    private Label msg;
    @FXML
    public void initialize(){
        pdisp show = ProdSingleton.getInstance();
        details = show;
        
        name.setText(show.name);
        prc.setText("$ "+show.price);
        desc.setText(show.desc);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(show.img);
        Image image = new Image(inputStream);
        img.setImage(image);
        
        
    }
    @FXML
    public void addToCart(){
        Cart cart = CartSingleton.getInstance();
        cart.addToCart(details);
        msg.setText("Item added to Cart");
    }
    @FXML
    private void GoBack()throws IOException{
        App.setRoot("Home");
    }
    
}
