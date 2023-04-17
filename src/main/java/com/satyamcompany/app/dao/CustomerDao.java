package com.satyamcompany.app.dao;

        import java.util.List;
        import java.util.Optional;
        import com.satyamcompany.app.model.Customer;

public interface CustomerDao {
//Select all customer
    List<Customer> getAllCustomer();
    
    //Select customer by id number
    Optional<Customer> getCustomerById(int customer_id);
    
    boolean createCustomer(Customer customer);
}

