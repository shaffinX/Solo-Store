/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.input.MouseEvent;
public class ProfileCController {
    @FXML
    private void CreateStr() throws IOException
    {
        App.setRoot("CreateStore");
    }
    @FXML
    private void GoBack() throws IOException
    {
        App.setRoot("Home");
    }
    @FXML
    private void ManageAcc(MouseEvent event) throws IOException
    {
        App.setRoot("ManageAccount");
    }
}
