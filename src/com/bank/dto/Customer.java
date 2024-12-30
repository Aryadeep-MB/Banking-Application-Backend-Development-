package com.bank.dto;

public class Customer {
	private long accno;
	private String name;
	private long phone;
	private String mail;
	private double bal;
	private int pin;
	
	
	public long getAccno() {
		return accno;
	}
	public String getName() {
		return name;
	}
	public long getPhone() {
		return phone;
	}
	public String getMail() {
		return mail;
	}
	public double getBal() {
		return bal;
	}
	public int getPin() {
		return pin;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
}
