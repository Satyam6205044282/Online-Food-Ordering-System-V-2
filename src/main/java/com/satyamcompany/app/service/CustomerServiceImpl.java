package com.satyamcompany.app.service;
       
import java.util.List;
import java.util.Optional;
import com.satyamcompany.app.dao.CustomerDao;
import com.satyamcompany.app.exceptions.ClassNotFoundException;
import com.satyamcompany.app.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao= customerDao;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	
	@Override
	public Customer getCustomerById(int customer_id) throws ClassNotFoundException{
		Optional<Customer> optionalCustomer = customerDao.getCustomerById(customer_id);
		if(optionalCustomer.isEmpty()) {
			throw new ClassNotFoundException("Customer not Exists with id: " + customer_id);
		}
		return optionalCustomer.get();
	}

	@Override
	public boolean createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}
}
