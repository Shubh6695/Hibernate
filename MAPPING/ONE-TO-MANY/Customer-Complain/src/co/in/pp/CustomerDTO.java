package co.in.pp;

import java.util.*;


public class CustomerDTO 
{

	private Integer cid, mobile;
	
	private String name, email, address;
	
	
	private Set CustomerChild;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
