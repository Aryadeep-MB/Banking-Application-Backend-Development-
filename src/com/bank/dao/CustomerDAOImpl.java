package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.connection.ConnectionFactory;
import com.bank.dto.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	private Connection con;
	public CustomerDAOImpl()
	{
	this.con=ConnectionFactory.requestConnection();
	}
	

	@Override
	public boolean insertCustomer(Customer c) {
	PreparedStatement ps=null;
	String query="INSERT INTO CUSTOMER(NAME,PHONE,MAIL,PIN)VALUES(?,?,?,?)";
	int res=0;
	try {
	con.setAutoCommit(false);
	ps=con.prepareStatement(query);
	ps.setString(1,c.getName());
	ps.setLong(2, c.getPhone());
	ps.setString(3, c.getMail());
	ps.setInt(4, c.getPin());
	res=ps.executeUpdate();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	if(res>0)
	{
	try {
	con.commit();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	return true;
	}
	else
	{
	try {
	con.rollback();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return false;
		}
		
}
	

	@Override
	public Customer getCustomer(long accno, int pin) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		Customer c=null;
		
		String query="SELECT * FROM CUSTOMER WHERE ACC_NO=? AND PIN=?";
		
		try {
		ps=con.prepareStatement(query);//to send query
		ps.setLong(1,accno);//to pass acc nbr and pin to query using ps.setXXX() methood
		ps.setInt(2, pin);
		rs=ps.executeQuery();//Here ps will exicute using executeQuery() method and stored in result set
		
		if(rs.next()) //it check in one after another as per the sql records
		{
		c=new Customer();
		c.setAccno(rs.getInt(1)); //here we set the value to customer object by getting from sql using rs.-> getint() method 
		c.setName(rs.getString(2));
		c.setPhone(rs.getLong(3));
		c.setMail(rs.getString(4));
		c.setBal(rs.getDouble(5));
		c.setPin(rs.getInt(6));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return c; //return c object which is storing all single customer records as per the request 
			
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomer(long accno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getCustomer() {
		PreparedStatement ps=null;
		ArrayList<Customer> customers=new ArrayList<Customer>();//creat list collection to store all records from the sql 
		ResultSet rs=null;
		Customer c=null;
		String query="SELECT * FROM CUSTOMER";
		try {
		ps=con.prepareStatement(query);
		rs=ps.executeQuery();
		while(rs.next())
		{
		c=new Customer();
		c.setAccno(rs.getInt(1));
		c.setName(rs.getString(2));
		c.setPhone(rs.getLong(3));
		c.setMail(rs.getString(4));
		c.setBal(rs.getDouble(5));
		c.setPin(rs.getInt(6));
		
		customers.add(c);//add all recordes in c to arraylist collection
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return customers; //return List object
	}
	

	@Override
	public boolean updateCustomer(Customer c) {
		PreparedStatement ps=null;
		int res=0;
		String query="UPDATE CUSTOMER SET NAME = ? WHERE ACC_NO=?";
		try {
		con.setAutoCommit(false);
		ps=con.prepareStatement(query);
		ps.setString(1, c.getName());
		ps.setLong(2, c.getAccno());
		res=ps.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(res>0)
		{
			try {
			con.commit();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return true;
			}
			else
			{
			try {
			con.rollback();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return false;
			}
			}
			

	@Override
	public boolean deleteCustomer(Customer c) {
		PreparedStatement ps=null;
		int res=0;
		String query="DELETE FROM CUSTOMER WHERE ACC_NO=?";
		try {
		con.setAutoCommit(false);
		ps=con.prepareStatement(query);
		ps.setLong(1, c.getAccno());
		res=ps.executeUpdate();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(res>0)
		{
			try {
			con.commit();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return true;
			}
			else
			{
			try {
			con.rollback();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return false;
			}
			}
	}


