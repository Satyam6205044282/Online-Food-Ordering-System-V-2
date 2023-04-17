package com.satyamcompany.app.service;

import java.util.List;

import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Customer;

public interface CustomerService {
	
	 List<Customer> getAllCustomer();
	 
	    Customer getCustomerById(int customer_id) throws ClassNotFoundException;
	    
	    boolean createCustomer(Customer customer);
}

