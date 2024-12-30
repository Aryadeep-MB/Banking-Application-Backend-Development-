package com.bank.app;

import com.bank.dto.Customer;

import com.bank.dao.*;
import java.util.Scanner;
public class Login {
	public static void login() {
	Scanner sc=new Scanner(System.in);
	CustomerDAO cdao=(CustomerDAO) new CustomerDAOImpl();
	System.out.println("Enter your Account number");
	long accno=sc.nextLong();
	System.out.println("Enter your PIN");
	int pin=sc.nextInt();
	Customer c=cdao.getCustomer(accno, pin);
	if(c!=null)
	{
	System.out.println("Login successful!");
	App.options(c);
	}
	else
	{
	System.out.println("Failed to login!");
	}
	}
	
}
