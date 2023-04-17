package com.satyamcompany.app.dao;

        import java.util.List;

import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.model.MenuType;

public interface MenuTypeDao {
//Select all menu-type
    List<MenuType> getAllMenuType();
    
    //Select menu-type by name
    List<Menu> getMenuByMenuType(String type_name);
    
    boolean createMenuType(MenuType menuType);

	
}


