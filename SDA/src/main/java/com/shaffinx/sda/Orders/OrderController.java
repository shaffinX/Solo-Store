/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Orders;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author shaff
 */
public class OrderController {
    private CreateOrder create;
    private ReadOrders read;
    public boolean Create(Orders order){
        create = new CreateOrder();
        return create.Create(order);
    }
    public ResultSet Read(int orderid,String CHK) throws SQLException{
        read = new ReadOrders();
        return read.Read(orderid,CHK);
    }
}
