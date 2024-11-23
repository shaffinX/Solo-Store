/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.shaffinx.sda;
import java.sql.ResultSet;
import com.shaffinx.sda.Orders.OrderController;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import com.shaffinx.sda.Session.Session;
import com.shaffinx.sda.Session.SessionSingelton;
import java.io.IOException;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class OrderHistoryController {
    private ResultSet Data;
    
    @FXML
    private TableView<OrderModel> display;
    @FXML
    private TableColumn<OrderModel, String> order_id;
    @FXML
    private TableColumn<OrderModel, String> name;
    @FXML
    private TableColumn<OrderModel, String> date;
    @FXML
    private TableColumn<OrderModel, String> price;
    
    private ObservableList<OrderModel> list = FXCollections.observableArrayList();
    
    @FXML
    private Spinner<Integer> id;
    @FXML
    private Label err;
    
    private int GetOrderid() throws SQLException{
        Session sess = SessionSingelton.getInstance();
        exec EXE = ExecSingleton.getInstance();
        //ResultSet alpha=EXE.Get("Select orderid from orders where customerid = "+sess.id);
        //alpha.next();
        //int res = alpha.getInt("orderid");
        return 2;
    }
    @FXML
    public void initialize() throws SQLException{
        id.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 999999, 0));
        
        order_id.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        int odid= GetOrderid();
        OrderController alpha = new OrderController();
        Data = alpha.Read(odid,"customerid");

        while(Data.next()){
            list.add(new OrderModel(
                Data.getInt("orderid"),
                Data.getString("prodname"),
                Data.getString("date"),
                Data.getInt("price")
                
            ));
        }
        display.setItems(list);
        
    }
    @FXML
    private void Refund()throws SQLException{
        if(id.getValue()!=0){
            OrderController alpha = new OrderController();
            Data = alpha.Read(id.getValue(),"orderid");
            Data.next();
            String date = String.valueOf(Data.getDate("date"));
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = today.format(formatter);
            
            if(formattedDate.equals(date)){
                err.setText("Your Order is Refunded");
            }
            else{
               err.setText("Your Order can't be Refunded"); 
            }
        }
        else{
            err.setText("Please Fill all Fields!");
        }
    }
    @FXML
    private void GoBack() throws IOException{
        App.setRoot("ProfileC");
    }
}
