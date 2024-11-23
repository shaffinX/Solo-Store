/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import javafx.fxml.FXML;
import java.io.IOException;

import javafx.scene.input.MouseEvent;

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
}