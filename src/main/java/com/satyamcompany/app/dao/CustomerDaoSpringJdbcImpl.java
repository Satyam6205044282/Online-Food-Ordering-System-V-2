package com.satyamcompany.app.dao;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.satyamcompany.app.model.Customer;

public class CustomerDaoSpringJdbcImpl implements CustomerDao{
	private static String CREATE_CUSTOMER= "insert into customer(customer_id, customer_first_name, customer_last_name, customer_email, customer_phone_number, customer_username, customer_password, account_status) values (?,?,?,?,?,?,?,?)";
	private static String FIND_ALL_CUSTOMER= "select * from customer";
	private static String FIND_CUSTOMER_BY_ID= "select * from customer where customer_id=?";
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Customer> getAllCustomer(){
		return jdbcTemplate.query(FIND_ALL_CUSTOMER, new CustomerMapper());
	}

	
//	@Override
//	public List<Customer> getAllCustomer(){
//		return jdbcTemplate.query(FIND_ALL_CUSTOMER,
//				(rs,no)-> new Customer(rs.getInt("customer_id"), 
//							rs.getString("customer_first_name"), 
//							rs.getString("customer_last_name"), 
//							rs.getString("customer_email"), 
//							rs.getString("customer_phone_number"), 
//							rs.getString("customer_username"), 
//							rs.getString("customer_password"), 
//							rs.getInt("customer_status"))
//		);
//	}
	
	@Override
	public Optional<Customer> getCustomerById(int customer_id){
	    Customer customer = jdbcTemplate.queryForObject(FIND_CUSTOMER_BY_ID, new CustomerMapper(), customer_id);
	    return Optional.of(customer);
	}
	
	@Override
	public boolean createCustomer(Customer customer) {
		return jdbcTemplate.update(CREATE_CUSTOMER, customer.getCustomerId(), customer.getCustomerFirstName(), customer.getCustomerLastName(), customer.getCustomerEmail(),
				customer.getCustomerPhoneNumber(), customer.getCustomerUsername(), customer.getCustomerPassword(), customer.getAccountStatus()) >0;
	}
	
}
