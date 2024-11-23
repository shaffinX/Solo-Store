/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.ManageProducts;
import java.sql.ResultSet;

public interface ProductProcess {
    public boolean create(Product product);
    public boolean update(Product product,int storeid,int prodid);
    public boolean delete(int pid);
    public ResultSet read(int storeid);
}
