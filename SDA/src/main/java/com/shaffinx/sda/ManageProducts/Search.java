package com.shaffinx.sda.ManageProducts;

import com.shaffinx.sda.DBFactory.ExecSingleton;
import com.shaffinx.sda.DBFactory.exec;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
    public ResultSet searchProducts(String keyword, int storeId) {
        exec dbExec = ExecSingleton.getInstance();
        String query = "SELECT * FROM products WHERE storeid = " + storeId + 
                       " AND (LOWER(prodname) LIKE LOWER('%" + keyword + "%') " +
                       "OR LOWER(pdesc) LIKE LOWER('%" + keyword + "%'))";
        ResultSet resultSet = null;

        try {
            resultSet = dbExec.Get(query);
        } catch (SQLException e) {
            System.err.println("SQL Error while searching products: " + e.getMessage());
            e.printStackTrace();
        }

        return resultSet;
    }
}
