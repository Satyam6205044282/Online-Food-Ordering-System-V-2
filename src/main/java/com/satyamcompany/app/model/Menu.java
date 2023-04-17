package com.satyamcompany.app.model;

public class Menu {
	    private int menu_id;
	    private String menu_name;
	    private float price;
	    private int menu_type_id;
		
	    public Menu() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Menu(String menu_name, float price, int menu_type_id) {
			super();
			
			this.menu_name = menu_name;
			this.price = price;
			this.menu_type_id = menu_type_id;
			
		}
		
		public Menu(String menu_name, float price) {
			super();
			this.menu_name = menu_name;
			this.price = price;
			
		}

		public int getMenuId() {
			return menu_id;
		}

		public void setMenuId(int menu_id) {
			this.menu_id = menu_id;
		}

		public String getMenuName() {
			return menu_name;
		}

		public void setMenuName(String menu_name) {
			this.menu_name = menu_name;
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getMenuTypeId() {
			return menu_type_id;
		}

		public void setMenuTypeId(int menu_type_id) {
			this.menu_type_id = menu_type_id;
		}

		

		@Override
		public String toString() {
			return "Menu [menu_name=" + menu_name + ", price=" + price + "]" + "\n";
		}

	    
	    
}