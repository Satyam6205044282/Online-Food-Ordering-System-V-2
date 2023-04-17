package com.satyamcompany.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.satyamcompany.app.model.Customer;

public class CustomerMapper implements RowMapper<Customer>{
	
	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer( 
				                         rs.getString("customer_first_name"), 
			                           	 rs.getString("customer_last_name"), 
			                       	     rs.getString("customer_email"), 
				                         rs.getString("customer_phone_number"), 
				                         rs.getString("customer_username"), 
				                         rs.getString("customer_password"), 
				                         rs.getInt("account_status")
				                         );
        return customer;	
	}


}
