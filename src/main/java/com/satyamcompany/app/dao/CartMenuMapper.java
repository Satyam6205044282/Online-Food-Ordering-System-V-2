package com.satyamcompany.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.model.Menu;

//To get Menu name by Menu-Type name input
public class CartMenuMapper implements RowMapper<Cart> {
    public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
        int customerId = rs.getInt("customer_id");
        int menuId = rs.getInt("menu_id");
        float price = rs.getFloat("price");
        int quantity = rs.getInt("quantity");
        float totalAmount = rs.getFloat("price * quantity");

        Cart cart = new Cart(customerId, menuId, price, quantity, totalAmount);
        return cart;
    }
}


