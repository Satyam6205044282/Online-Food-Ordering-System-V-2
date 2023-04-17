package com.satyamcompany.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.satyamcompany.app.model.Menu;

public class MenuMapper implements RowMapper<Menu>{
	
	@Override
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu menu = new Menu( 
                             rs.getString("menu_name"), 
              	             rs.getFloat("price")
                             );
        return menu;	
	}


}

