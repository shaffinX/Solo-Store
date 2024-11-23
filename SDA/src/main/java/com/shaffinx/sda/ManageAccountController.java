/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;
public class ManageAccountController {
   @FXML
   private PasswordField pass;
   @FXML
   private PasswordField cgpass;
   @FXML
   private Label err;
   @FXML
   private void ChangePass(){
       if(!"".equals(pass.getText()) && !"".equals(cgpass.getText())){
           Session s = SessionSingelton.getInstance();
           int id = s.id;
           if(pass.getText().equals(cgpass.getText())){
               String sha256Hex = DigestUtils.sha256Hex(pass.getText());
               exec Exe = ExecSingleton.getInstance();
               String query = "Update users set password = '"+sha256Hex+"' where id = "+id;
               if(Exe.Update(query)){
                    err.setText("Password Updated!");
                }
                else{
                    err.setText("Error Processing Request");
                }
           }
           else{
               err.setText("Both Fields Don't match!");
           }
       }
       else{
           err.setText("Please! Fill the entries");
       }
   }
   @FXML
   private void GoBack() throws IOException
   {
       Session s = SessionSingelton.getInstance();
       if("customer".equals(s.role)){
           App.setRoot("ProfileC");
       }else{
           App.setRoot("ProfileS");
       }
        
   }
}
