/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.ManageProducts;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import java.sql.ResultSet;

/**
 *
 * @author shaff
 */
public class Delete implements ProductProcess{
    @Override
    public boolean create(Product product){return false;}
    @Override
    public boolean update(Product product,int storeid,int prodid){return false; }
    @Override
    public boolean delete(int pid){
        exec Exec = ExecSingleton.getInstance();
        String query = "delete from products where prodid = "+pid;
        if(Exec.Update(query)){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public ResultSet read(int storeid){ResultSet s=null; return s;}
}
