/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Orders;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadOrders {
    public ResultSet Read(int id, String CHK)throws SQLException{
        exec Exe = ExecSingleton.getInstance();
        String query;
        if("orderid".equals(CHK)){
            query = "select prodname,price,date,orderid from orders join products on orders.prodid = products.prodid where orders.orderid = "+id;
            
        }
        else{
            query = "select prodname,price,date,orderid from orders join products on orders.prodid = products.prodid where orders.customerid = "+id;
        }
        return Exe.Get(query);
    }
}
