package co.in.pp;

import java.util.*;

public class ManufacturerDTO 
{

	
	private Integer mid;
	
	private String mname, memail;
	
	
	private Set productParent;
	
	private Set customerChild;

	
	
	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public Set getProductParent() {
		return productParent;
	}

	public void setProductParent(Set productParent) {
		this.productParent = productParent;
	}

	public Set getCustomerChild() {
		return customerChild;
	}

	public void setCustomerChild(Set customerChild) {
		this.customerChild = customerChild;
	}
	
	
}
