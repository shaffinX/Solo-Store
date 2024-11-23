/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.ManageProducts;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author shaff
 */
public class Read implements ProductProcess{
    @Override
    public boolean create(Product product){return false;}
    @Override
    public boolean update(Product product,int storeid,int prodid){ return false;}
    @Override
    public boolean delete(int pid){return false;}
    @Override
    public ResultSet read(int storeid){
        String query = "Select * from products where storeid = "+storeid;
        exec alpha = ExecSingleton.getInstance();
        ResultSet s=null;
        try{
            s = alpha.Get(query);
        }
        catch(SQLException e){
            System.err.println("An SQL exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        
        return s;
    }
}
