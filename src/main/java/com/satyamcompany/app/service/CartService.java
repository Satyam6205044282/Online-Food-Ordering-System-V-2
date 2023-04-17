package com.satyamcompany.app.service;
import java.util.List;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.model.MenuType;
import com.satyamcompany.app.model.Menu;

public interface CartService {
	
	List<Cart> getCartList();
	boolean addMenuToCart(Cart cart);
	
}





