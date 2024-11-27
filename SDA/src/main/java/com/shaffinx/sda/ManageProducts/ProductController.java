/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaffinx.sda.ManageProducts;
import java.sql.ResultSet;

/**
 *
 * @author shaff
 */
public class ProductController {
    private Create createProduct;
    private Update updateProduct;
    private Delete deleteProduct;
    private Read readProduct;
    
    public boolean Create(Product product)
    {
        createProduct = new Create();
        return createProduct.create(product);
    }
    public boolean Update(Product product,int storeid,int prodid)
    {
        updateProduct=new Update();
        return updateProduct.update(product,storeid,prodid);
    }
    public boolean Delete(int pid)
    {
        deleteProduct = new Delete();
        return deleteProduct.delete(pid);
    }
    public ResultSet Read(int storeid)
    {
        readProduct = new Read();
        ResultSet R = readProduct.read(storeid);
        return R;
    }
    
    private Search searchProduct;

    public ResultSet Search(String keyword, int storeId) {
        searchProduct = new Search();
        return searchProduct.searchProducts(keyword, storeId);
    }
}

