package com.satyamcompany.app.dao;

import java.util.List;
import com.satyamcompany.app.model.Cart;

public interface CartDao {
	boolean addMenuToCart(Cart cart);
	List<Cart> getCartList();

}
