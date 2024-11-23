/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.Orders;
import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
public class CreateOrder {
    public boolean Create(Orders order){
        exec Exe = ExecSingleton.getInstance();
        String query = "Insert into orders(date,prodid,customerid) values('"+order.getDate()+"',"+order.getProdId()+","+order.getCustomId()+")";
        return Exe.Update(query);
    }
}
