package com.satyamcompany.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.satyamcompany.app.model.Menu;

// To get Menu name by Menu-Type name input
public class MenuTypeMenuMapper implements RowMapper<Menu> {
	public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Menu menu= new Menu( 
				            rs.getString("menu_name"),
                            rs.getInt("price")
                            );
		
		return menu;
	}


}
