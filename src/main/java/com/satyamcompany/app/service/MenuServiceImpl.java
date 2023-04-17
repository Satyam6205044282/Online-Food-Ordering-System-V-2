package com.satyamcompany.app.service;
       
import java.util.List;
import java.util.Optional;
import com.satyamcompany.app.dao.MenuDao;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Menu;

public class MenuServiceImpl implements MenuService {
	
	private MenuDao menuDao;
	
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
	
	@Override
	public List<Menu> getAllMenu() {
		return menuDao.getAllMenu();
	}
	
	@Override
	public Menu getMenuByName(String menu_name) throws ClassNotFoundException{
		Optional<Menu> optionalMenu = menuDao.getMenuByName(menu_name);
		if(optionalMenu.isEmpty()) {
			throw new ClassNotFoundException("Menu not Exists with Name: " + menu_name);
		}
		return optionalMenu.get();
	}

	@Override
	public boolean createMenu(Menu menu) {
		return menuDao.createMenu(menu);
	}
}
