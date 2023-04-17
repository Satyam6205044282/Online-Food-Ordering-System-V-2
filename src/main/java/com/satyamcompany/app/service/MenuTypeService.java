package com.satyamcompany.app.service;

import java.util.List;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.model.MenuType;

public interface MenuTypeService {
	
	    List<MenuType> getAllMenuType();
	    
	    boolean createMenuType(MenuType menuType);

		List<Menu> getMenuByMenuType(String type_name) throws ClassNotFoundException;
}
