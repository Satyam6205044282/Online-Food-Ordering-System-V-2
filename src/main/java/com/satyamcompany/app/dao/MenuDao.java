package com.satyamcompany.app.dao;

        import java.util.List;
        import java.util.Optional;
        import com.satyamcompany.app.model.Menu;

public interface MenuDao {
//Select all menu
    List<Menu> getAllMenu();
    
    //Select menu by id
    Optional<Menu> getMenuByName(String menu_name);
    
    boolean createMenu(Menu menu);
}