package com.satyamcompany.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
import com.satyamcompany.app.exceptions.ClassNotFoundException; 
import com.satyamcompany.app.model.Customer;
import com.satyamcompany.app.service.CustomerService;
import com.satyamcompany.app.model.Menu;
import com.satyamcompany.app.service.MenuService;
import com.satyamcompany.app.model.MenuType;
import com.satyamcompany.app.service.MenuTypeService;
import com.satyamcompany.app.model.Cart;
import com.satyamcompany.app.service.CartService;


public class App{
    public static void main(String[] args) {
        
       
        
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~ || WELCOME TO ONLINE FOOD ORDERING || ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
    	CustomerService customerService = (CustomerService) context.getBean("customerService");
    	MenuService menuService = (MenuService) context.getBean("menuService");
    	MenuTypeService menuTypeService = (MenuTypeService) context.getBean("menuTypeService");
    	CartService cartService = (CartService) context.getBean("cartService");
    	
    	Scanner sc= new Scanner(System.in);
    	while(true) {
    		System.out.println("Press 1. Customer Registration and Login");
    		System.out.println("Press 2. Lists the Customer");
    		System.out.println("Press 3. Search Customer by ID");
    		System.out.println("Press 4. for Add Menu");
    		System.out.println("Press 5. View all Menu-items");
    		System.out.println("Press 6. Search Menu by name");
    		System.out.println("Press 7. Add Menu-Type");
    		System.out.println("Press 8. Search Menu-Type by name from the menu-type list");
    		System.out.println("Press 9. Add to Cart");
    		System.out.println("Press 10. View Cart");
    		System.out.println("Press 11. for Exit");
    		System.out.println("================  || Enter your choices: ||  ==================");
    		int ch= Integer.parseInt(sc.nextLine());
    		
    		
    		switch(ch){
    			case 1:
    				System.out.println("------------ Customer Registration and Login -----------");
    				System.out.println("==============================================================\n");
    				System.out.println("Enter Customer First Name: ");
    				String fname= sc.nextLine();
    				
    				System.out.println("Enter Customer Last Name: ");
    				String lname= sc.nextLine();
    				
    				System.out.println("Enter Customer Email: ");
    				String email= sc.nextLine();
    				
    				System.out.println("Enter Customer Phone Number");
    				String phone= sc.nextLine();

    				System.out.println("Enter Customer Username: ");
    				String username= sc.nextLine();

    				System.out.println("Enter Customer Password: ");
    				String password= sc.nextLine();

    				System.out.println("Enter Customer Account Status: ");
    				int status= Integer.parseInt(sc.nextLine());
    				
    				Customer customer= new Customer(fname, lname, email, phone, username, password, status);
    				customerService.createCustomer(customer);
    				
    				
    				System.out.println("------------ Customer Login -----------");
    				System.out.println("===============================================\n");
    				
    				System.out.println("Enter Username: ");
    				String username1= sc.nextLine();
    				
    				System.out.println("Enter Password:");
    				String password1= sc.nextLine();
    				
    				if(username1.equals(customer.getCustomerUsername()) && password1.equals(customer.getCustomerPassword())){
    					System.out.println("***********Congratulation You Login Successfully*************\n");
    				}else {
    					System.out.println("////////   Invalid Username or Password   \\\\\\\\\n");
    				}
    				break;
    				
    			case 2:
                    System.out.println("Customer List:");
                    System.out.println("=======================\n");
                    customerService.getAllCustomer().forEach(System.out::println);
                    break;
    			case 3:
    				System.out.println("Enter Customer Id to be searched:");
    				int customerId= Integer.parseInt(sc.nextLine());
    				try {
    					System.out.println(customerService.getCustomerById(customerId));
    				}catch (ClassNotFoundException e){
    					System.err.println(e.getMessage());
    				}
    				break;
    			case 4:
    				System.out.println("Enter Menu Name:");
    				String menuName= sc.nextLine();
    				
    				System.out.println("Enter Menu Price:");
    				Float price= Float.parseFloat(sc.nextLine());
    				
    				System.out.println("Enter Menu-Type Id:");
    				int menuTypeId= Integer.parseInt(sc.nextLine());
    				
    				
    				Menu menu= new Menu(menuName, price, menuTypeId);
    				menuService.createMenu(menu);
    				break;
    			case 5:
                    System.out.println("Menu List: ");
                    System.out.println("=========================\n");
                    menuService.getAllMenu().forEach(System.out::println);
                    break;
    			case 6:
    				System.out.println("Enter Menu Name to be searched: ");
    				String menuname= sc.nextLine();
    				try {
    					System.out.println(menuService.getMenuByName(menuname));
    				}catch (ClassNotFoundException e){
    					System.err.println(e.getMessage());
    				}
    				break;
    		    case 7:
    				System.out.println("Enter Menu-Type Id:");
    				int menuTypeid= Integer.parseInt(sc.nextLine());
    				
    				System.out.println("Enter Menu Name:");
    				String typeName= sc.nextLine();
    				
    				System.out.println("Enter Menu Description:");
    				String description= sc.nextLine();
    				
    				
    				MenuType menuType= new MenuType(menuTypeid, typeName, description);
    				menuTypeService.createMenuType(menuType);
    				break;
    			case 8:
                    System.out.println("MenuType List: ");
                    System.out.println("==============================\n");
                    menuTypeService.getAllMenuType().forEach(System.out::println);
                    
                    //Searching menu type by name
    				System.out.println("Select the Menu-Type Name : ");
    				String typename= sc.nextLine();
    				try {
    					System.out.println(menuTypeService.getMenuByMenuType(typename));
    				}catch (ClassNotFoundException e){
    					System.err.println(e.getMessage());
    				}
    				break;
    				
    				
    				
    			case 9:
    					// Show all available Genre
    					System.out.println("~~~~~~~~~~~~~~~~~~~~ Menu-Type List ~~~~~~~~~~~~~~~~~~~~");
    					menuTypeService.getAllMenuType().forEach(System.out::println);
    					
    					// Searching Genre by Name
    					System.out.println("Select Menu-Type from this Category list :");
    					String MenuTypeName = sc.nextLine();
    					try {
    						menuTypeService.getMenuByMenuType(MenuTypeName).forEach(System.out::println);
    						
    						System.out.println("Select Menu Name from the list :");
    						String cartMenuName = sc.nextLine();
    						System.out.println("Enter Customer Id :");
    						int cartCustomerId = Integer.parseInt(sc.nextLine());
    						System.out.println("Enter Quantity :");
    						int cartMenuQuantity = Integer.parseInt(sc.nextLine());
    						
    						Cart cart = new Cart(cartMenuName, cartCustomerId, cartMenuQuantity);
    						cartService.addMenuToCart(cart);
    						
//    						cartService.addMenuToCart(cartMenuName,cartMenuQuantity);
//    						cartService.getCartList().forEach(System.out::println);

    					} catch (ClassNotFoundException e) {
    						System.err.println(e.getMessage());
    					}
    					break;
    			 
    				
    				// Show All Users 
    			case 10:
    					System.out.println("~~~~~~~~~~~~~~~~~~~~ Cart List ~~~~~~~~~~~~~~~~~~~~");
    					cartService.getCartList().forEach(System.out::println);
    					break;
    			
    				
    				
    				
    				
    				
    				
    				
    				
    				
    				
    			case 11: 
    				System.exit(1);
    				System.out.println("************* Thankyou For using Online Food Ordering *************");
    		}
   		
    	}
        
           
    }
 }
 
        
        
        
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
        
        
        
        
        
        
//        System.out.println("\n---CUSTOMER---");
//       
//        	ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
//        	CustomerService customerService = (CustomerService) context.getBean("customerService");
//        	
//        	Scanner sc= new Scanner(System.in);
//        	while(true) {
//        		System.out.println("1. for Add Customer");
//        		System.out.println("2. for List the Customer");
//        		System.out.println("3. for Search Customer");
//        		System.out.println("4. for Exit");
//        		System.out.println("Enter your choice:");
//        		int ch= Integer.parseInt(sc.nextLine());
//        		
//        		switch(ch){
//        			case 1:
//        				System.out.println("Enter Customer Id: ");
//        				int id= Integer.parseInt(sc.nextLine());
//        				
//        				System.out.println("Enter Customer First Name: ");
//        				String fname= sc.nextLine();
//        				
//        				System.out.println("Enter Customer Last Name: ");
//        				String lname= sc.nextLine();
//        				
//        				System.out.println("Enter Customer Email: ");
//        				String email= sc.nextLine();
//        				
//        				System.out.println("Enter Customer Phone Number");
//        				String phone= sc.nextLine();
//
//        				System.out.println("Enter Customer Username: ");
//        				String username= sc.nextLine();
//
//        				System.out.println("Enter Customer Password: ");
//        				String password= sc.nextLine();
//
//        				System.out.println("Enter Customer Account Status: ");
//        				int status= Integer.parseInt(sc.nextLine());
//        				
//        				Customer customer= new Customer(id, fname, lname, email, phone, username, password, status);
//        				customerService.createCustomer(customer);
//        				break;
//        			case 2:
//                        System.out.println("Customer List:");
//                        customerService.getAllCustomer().forEach(System.out::println);
//                        break;
//        			case 3:
//        				System.out.println("Enter Customer Id to be searched:");
//        				int customerId= Integer.parseInt(sc.nextLine());
//        				try {
//        					System.out.println(customerService.getCustomerById(customerId));
//        				}catch (ClassNotFoundException e){
//        					System.err.println(e.getMessage());
//        				}
//        				break;
//        			case 4: 
//        				System.exit(1);
//        		}
//       		
//       	}
//        		
//        		
      		
        		
        		
        		
//        System.out.println("\n---MENU---");
//        		
//        		
//        		ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
//            	MenuService menuService = (MenuService) context.getBean("menuService");
//            	
//            	Scanner sc1= new Scanner(System.in);
//            	while(true) {
//            		System.out.println("1. for Add Menu");
//            		System.out.println("2. for List the Menu");
//            		System.out.println("3. for Search Menu by name");
//            		System.out.println("4. for Exit");
//            		System.out.println("Enter your choice:");
//            		int ch1= Integer.parseInt(sc1.nextLine());
//            		
//            		switch(ch1){
//            			case 1:
//            				System.out.println("Enter Menu Id:");
//            				int menuId= Integer.parseInt(sc1.nextLine());
//            				
//            				System.out.println("Enter Menu Name:");
//            				String menuName= sc1.nextLine();
//            				
//            				System.out.println("Enter Menu Price:");
//            				Float price= Float.parseFloat(sc1.nextLine());
//            				
//            				System.out.println("Enter Menu-Type Id:");
//            				int menuTypeId= Integer.parseInt(sc1.nextLine());
//            				
//            				
//            				Menu menu= new Menu(menuId, menuName, price, menuTypeId);
//            				menuService.createMenu(menu);
//            				break;
//            			case 2:
//                            System.out.println("Menu List: ");
//                            menuService.getAllMenu().forEach(System.out::println);
//                            break;
//            			case 3:
//            				System.out.println("Enter Menu Name to be searched: ");
//            				String menuname= sc1.nextLine();
//            				try {
//            					System.out.println(menuService.getMenuByName(menuname));
//            				}catch (ClassNotFoundException e){
//            					System.err.println(e.getMessage());
//            				}
//            				break;
//            			case 4: 
//            				System.exit(1);
//            		}     		
//                }
            	
            	
            	
    

