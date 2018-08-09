package co.in.pp;

import java.util.*;

public class ManufacturerDTO 
{

	
	private Integer mid, pid;
	
	private String mname;
	
	
	private Set CustomerChild;

	

	public Integer getMid() {
		return mid;
	}


	public void setMid(Integer mid) {
		this.mid = mid;
	}


	
	
	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public Set getCustomerChild() {
		return CustomerChild;
	}


	public void setCustomerChild(Set customerChild) {
		CustomerChild = customerChild;
	}
	
	
	
}
