/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.repository;

import com.pbo.responsi.database.DatabaseConnection;
import com.pbo.responsi.model.CartItem;
import com.pbo.responsi.model.CartRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public class MysqlCartRepository {
    implements CartRepository {
    
    public List<CartItem> getAll() {
        List<CartItem> items = 
                new ArrayList<>();
        String quesry = 
                "SELECT * FROM cart";
        try (
            Connection conn = 
                    DatabaseConnection.getConnection();
            Statement stmt =
                    conn.createStatement();
            ResultSet rs = 
                    stmt.executeQuery(quesry);
            ){
            while(rs.next()) {
                e.printStackTrace();
                rs.getString("name");
                rs.getDouble("price");
                rs.getInt("qty");
            }
                
                            
            
        } catch (Exception e) {
        }
    }
    }
}
