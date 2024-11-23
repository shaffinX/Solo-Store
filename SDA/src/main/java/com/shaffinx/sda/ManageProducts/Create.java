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
public class Create implements ProductProcess {
    @Override
    public boolean create(Product product){
        exec Exec = ExecSingleton.getInstance();
        String query = "Insert into products(prodname,pdesc,price,img,storeid) values('"+product.getName()+"','"+product.getDesc()+"',"+product.getPrice()+",pg_read_binary_file('"+product.getImg()+"'),"+product.getstID()+")";
        if(Exec.Update(query)){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public boolean update(Product product,int storeid,int prodid){return false;}
    @Override
    public boolean delete(int pid){return false;}
    @Override
    public ResultSet read(int storeid){ResultSet s=null; return s;}
}
