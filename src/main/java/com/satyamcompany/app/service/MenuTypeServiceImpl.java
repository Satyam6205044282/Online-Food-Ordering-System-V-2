package com.satyamcompany.app.service;
       
import java.util.List;
import com.satyamcompany.app.dao.MenuTypeDao;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.model.MenuType;

public class MenuTypeServiceImpl implements MenuTypeService {
	
	private MenuTypeDao menuTypeDao;
	
	public void setMenuTypeDao(MenuTypeDao menuTypeDao) {
		this.menuTypeDao = menuTypeDao;
	}
	
	@Override
	public List<MenuType> getAllMenuType() {
		return menuTypeDao.getAllMenuType();
	}
	
	@Override
	public List<Menu> getMenuByMenuType(String type_name) throws ClassNotFoundException {
		
		List<Menu> Menus = menuTypeDao.getMenuByMenuType(type_name);
	    
	    if (Menus.isEmpty()) {
	        throw new ClassNotFoundException("Menu-Type Name does not Exists : " + type_name);
	    }
	    
	    return Menus;
	}

	@Override
	public boolean createMenuType(MenuType menuType) {
		return menuTypeDao.createMenuType(menuType);
	}
}
