package com.bank.dao;

import java.util.List;

import com.bank.dto.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer c);
	public Customer getCustomer(long accno,int pin); //To get the specific customer data
	public Customer getCustomer(long phone,String mail);//this to are not requered here 
	public Customer getCustomer(long accno);
	public List getCustomer();                     //To get all the data from sql table
	public boolean updateCustomer(Customer c);
	public boolean deleteCustomer(Customer c);
}
