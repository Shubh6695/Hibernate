package co.in.pp;

import java.util.*;

public class CustomerDTO 
{

	private Integer customerid, mobile;
	
	private String fname, lname, email, address;
	
	
	private Set CustomerChild;


	public Integer getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set getCustomerChild() {
		return CustomerChild;
	}


	public void setCustomerChild(Set customerChild) {
		CustomerChild = customerChild;
	}
	
	
	
	
	
	
}
