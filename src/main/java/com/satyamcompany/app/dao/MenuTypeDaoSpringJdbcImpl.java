package com.satyamcompany.app.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.model.MenuType;

public class MenuTypeDaoSpringJdbcImpl implements MenuTypeDao{
	private static String CREATE_MENU_TYPE= "insert into `menu-type`(menu_type_id, type_name, description) values (?,?,?)";
	private static String FIND_ALL_MENU_TYPE= "select * from `menu-type`";
	private static String FIND_MENU_BY_MENU_TYPE= "select menu_name, price from menu m join `menu-type` mt on m.`menu_type_id`= mt.`menu_type_id` where mt.`type_name`= ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<MenuType> getAllMenuType(){
		return jdbcTemplate.query(FIND_ALL_MENU_TYPE, new MenuTypeMapper());
	}

	

	
	@Override
	public boolean createMenuType(MenuType menuType) {
		return jdbcTemplate.update(CREATE_MENU_TYPE, menuType.getMenuTypeId(), menuType.getTypeName(), menuType.getDescription()) >0;
	}

	
	
	@Override
	public List<Menu> getMenuByMenuType(String type_name) {
		return jdbcTemplate.query(FIND_MENU_BY_MENU_TYPE, new MenuTypeMenuMapper(), type_name);
	}
	
}


