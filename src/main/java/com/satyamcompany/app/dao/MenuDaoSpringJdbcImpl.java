package com.satyamcompany.app.dao;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.satyamcompany.app.model.Menu;

public class MenuDaoSpringJdbcImpl implements MenuDao{
	private static String CREATE_MENU= "insert into menu(menu_id, menu_name, price, menu_type_id) values (?,?,?,?)";
	private static String FIND_ALL_MENU= "select * from menu";
	private static String FIND_MENU_BY_NAME= "select * from menu where menu_name=?";
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Menu> getAllMenu(){
		return jdbcTemplate.query(FIND_ALL_MENU, new MenuMapper());
	}

	

	
	@Override
	public Optional<Menu> getMenuByName(String menu_name){
	    Menu menu = jdbcTemplate.queryForObject(FIND_MENU_BY_NAME, new MenuMapper(), menu_name);
	    return Optional.of(menu);
	}
	
	
	@Override
	public boolean createMenu(Menu menu) {
		return jdbcTemplate.update(CREATE_MENU, menu.getMenuId(), menu.getMenuName(), menu.getPrice(), menu.getMenuTypeId()) >0;
	}
	
}
