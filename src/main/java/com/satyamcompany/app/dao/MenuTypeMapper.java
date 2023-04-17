package com.satyamcompany.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.satyamcompany.app.model.MenuType;

public class MenuTypeMapper implements RowMapper<MenuType>{
	
	@Override
	public MenuType mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuType menuType = new MenuType(rs.getInt("menu_type_id"), 
                             rs.getString("type_name"), 
              	             rs.getString("description")
                             );
        return menuType;	
	}


}
