/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import javafx.fxml.FXML;
import java.io.IOException;
import java.sql.SQLException;
import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import java.sql.ResultSet;
import org.apache.commons.codec.digest.DigestUtils;

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class LoginController {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField email;
    @FXML
    private PasswordField pass;
    @FXML
    private Label err;
    @FXML
    private void Login() throws IOException
    {
        if(email.getText()!="" && pass.getText()!=""){
            try{
                String sha256Hex = DigestUtils.sha256Hex(pass.getText());
                exec Exe = ExecSingleton.getInstance();
                String query ="Select * from users where password = '"+sha256Hex+"' And email = '"+email.getText()+"'";
                ResultSet x = Exe.Get(query);
                if(x.next()){
                    Session s = SessionSingelton.getInstance();
                    s.email = x.getString("email");
                    s.name = x.getString("name");
                    s.role = x.getString("role");
                    s.id = x.getInt("id");
                    
                    if("store".equals(s.role)){
                        query = "select stname from store where id = "+s.id;
                        ResultSet y = Exe.Get(query);
                        y.next();
                        s.storename = y.getString("stname");
                    }
                    
                    App.setRoot("Home");
                }
                else{
                    err.setText("Incorrect Email or Password!");
                }
                
            }
            catch (SQLException e){
                System.err.println("An SQL exception occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
        else{
            err.setText("Please! Fill the entries");
        }
    }
    @FXML
    private void setReg(MouseEvent event) throws IOException
    {
        App.setRoot("Register");
    }
  
    
}
