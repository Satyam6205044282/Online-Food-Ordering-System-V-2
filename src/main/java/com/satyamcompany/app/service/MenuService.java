package com.satyamcompany.app.service;

import java.util.List;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Menu;

public interface MenuService {
	
	    List<Menu> getAllMenu();
	 
	    Menu getMenuByName(String menu_name) throws ClassNotFoundException;
	    
	    boolean createMenu(Menu menu);
}

