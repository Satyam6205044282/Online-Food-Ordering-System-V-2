package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.dao.CartDao;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.model.Menu;

public class CartServiceImpl implements CartService {
	
	// CartDao -> setter
	private CartDao cartDao;

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	// Show all items from Cart
	public List<Cart> getCartList() {
		return cartDao.getCartList();
	}
	
	
//	@Override
//	public List<Cart> putBookToCart(String bookName, int quantity) throws ClassNotFoundException, SystemException {
//
//		return cartDao.getCartList();		
//		
//	    // Book list from ProductTable is inserted into Cart 
//		List<Product> Books = cartDao.putBookToCart(bookName ,quantity);
//	    
//	    if (Books.isEmpty()) {
//	        throw new ClassNotFoundException("Book :" + bookName + " does not Exists in the Cart with quantity :"+quantity );
//	    }
//	    
//	    return Books;
//	}

	
	public boolean addMenuToCart(Cart cart) {
		boolean newMenu = cartDao.addMenuToCart(cart);
		if(newMenu) {
			System.out.println("************** Menu is added to Cart successfully!!! **************");
		}
		else {
			System.out.println("Error : Unable to add Item to Cart. Sorry for inconvenience.");
		}
		return newMenu;
		
	}

}
