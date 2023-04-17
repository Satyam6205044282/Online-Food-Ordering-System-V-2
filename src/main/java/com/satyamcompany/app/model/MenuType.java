package com.satyamcompany.app.model;

public class MenuType {
	private int menu_type_id;
    private String type_name;
    private String description;
	public MenuType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuType(int menu_type_id, String type_name, String description) {
		super();
		this.menu_type_id = menu_type_id;
		this.type_name = type_name;
		this.description = description;
	}
	public int getMenuTypeId() {
		return menu_type_id;
	}
	public void setMenuTypeId(int menu_type_id) {
		this.menu_type_id = menu_type_id;
	}
	public String getTypeName() {
		return type_name;
	}
	public void setTypeName(String type_name) {
		this.type_name = type_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "MenuType [menu_type_id=" + menu_type_id + ", type_name=" + type_name + ", description=" + description
				+ "]\n";
	}
    
				
	
}
