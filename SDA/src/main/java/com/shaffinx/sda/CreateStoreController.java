/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import javafx.fxml.FXML;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import com.shaffinx.sda.DBFactory.exec;
import java.io.IOException;

import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class CreateStoreController {
     @FXML
    private TextField stn;
    @FXML
    private TextArea det;
    @FXML
    private Label err;
    
    @FXML
    private void CreateStr() throws IOException
    {
        if(stn.getText()!=""&&det.getText()!=""){
            Session s = SessionSingelton.getInstance();
            exec Exe = ExecSingleton.getInstance();
            
            String query = "Insert Into store(stname,stdesc,id) values('"+stn.getText()+"','"+det.getText()+"',"+s.id+")";
            if(Exe.Update(query)){
                query = "Update users set role = 'store' where id = "+s.id;
                if(Exe.Update(query)){
                    App.setRoot("Home");
                }else{
                    err.setText("An Error Occurred");
                }

            }
            else{
                err.setText("An Error Occurred");
            }
        }
        else{
            err.setText("Fill all the fields!");
        }
        
    }
    @FXML
    private void GoBack() throws IOException
    {
        App.setRoot("Home");
    }
}
