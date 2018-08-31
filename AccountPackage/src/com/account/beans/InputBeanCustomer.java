package com.account.beans;

public class InputBeanCustomer {

	private String fname;
	private String lname;
	private String gender;
	private boolean isMarried;
	private int accountType;
	private double balance;
	
	public InputBeanCustomer(String fname, String lname, String gender, boolean isMarried,
			int accountType, double balance) {
		setFname(fname);
		setLname(lname);
		setGender(gender);
		setMarried(isMarried);
		setAccountType(accountType);
		setBalance(balance);
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
