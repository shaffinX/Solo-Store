/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProfileSController {
   @FXML
   private Label greet;
   @FXML
   public void initialize()
   {
        Session s = SessionSingelton.getInstance();
        greet.setText("Hello! "+s.name+" Welcome to "+s.storename);
   }
   @FXML
    private void GoBack() throws IOException
    {
        App.setRoot("Home");
    }
    
    @FXML
    private void AddProduct(MouseEvent event) throws IOException
    {
        App.setRoot("AddProduct");
    }
    @FXML
    private void UpdateProduct(MouseEvent event) throws IOException
    {
        App.setRoot("UpdateProduct");
    }
    @FXML
    private void DeleteProduct(MouseEvent event) throws IOException
    {
        App.setRoot("DeleteProduct");
    }
    @FXML
    private void ManageAcc(MouseEvent event) throws IOException
    {
        App.setRoot("ManageAccount");
    }
}
