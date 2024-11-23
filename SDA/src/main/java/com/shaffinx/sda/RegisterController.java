/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;


public class RegisterController {
   @FXML
   private TextField name;
   @FXML
   private TextField email;
   @FXML
   private PasswordField pass;
   @FXML
   private Label err;
   @FXML
   public void Register() throws SQLException{
       if(name.getText()!="" && email.getText()!="" && pass.getText()!=""){
            exec Exe = ExecSingleton.getInstance();
            String query ="Select * from users where email = '"+email.getText()+"'";
            ResultSet x=Exe.Get(query);
            if(x.next()){
                err.setText("User Already Exists");
            }
            else{
                if(pass.getText().length()<8){
                    err.setText("Password Must be 8 characters long");
                }
                else{
                    String sha256Hex = DigestUtils.sha256Hex(pass.getText());
                    query ="Insert into users(name,email,password,role) values('"+name.getText()+"','"+email.getText()+"','"+sha256Hex+"','customer')";
                    if(Exe.Update(query)){
                        try{
                            App.setRoot("Login");
                        }
                        catch(IOException e){
                            System.out.print(e.getMessage());
                        }
                    }
                    else{
                        err.setText("Error Processing Request");
                    }
                }
               
            }
       }
       else{
           err.setText("Please! Fill the entries");
       }
   }
   @FXML
   private void GoBack() throws IOException
    {
        App.setRoot("Login");
    }
    
}
