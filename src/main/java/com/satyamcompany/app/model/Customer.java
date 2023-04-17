package com.satyamcompany.app.model;

public class Customer {
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerUsername;
    private String customerPassword;
    private int accountStatus;
   
    public Customer() {
        super();
//TODO Auto-generated constructor stub
    }

	public Customer(int customerId, String customerFirstName, String customerLastName, String customerEmail,
			String customerPhoneNumber, String customerUsername, String customerPassword, int accountStatus) {
		super();
		this.customerId = customerId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.accountStatus = accountStatus;
	}
	
	public Customer(String customerFirstName, String customerLastName, String customerEmail,
			String customerPhoneNumber, String customerUsername, String customerPassword, int accountStatus) {
		super();
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerEmail = customerEmail;
		this.customerPhoneNumber = customerPhoneNumber;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.accountStatus = accountStatus;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(int accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Customer [customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerEmail=" + customerEmail
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", customerUsername=" + customerUsername
				+ ", customerPassword=" + customerPassword + ", accountStatus=" + accountStatus + "]\n";
	}

   
}
