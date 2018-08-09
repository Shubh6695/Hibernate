package co.in.pp;

import java.util.*;

public class CustomerDTO 
{

	private Integer customerid;
	
	private String customername;
	
	private Set VendorParent;														// In Both class Set is used
	
																					// Reason Both Parent/Child hold multiple Child/Parent.


	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public Set getVendorParent() {
		return VendorParent;
	}

	public void setVendorParent(Set vendorParent) {
		VendorParent = vendorParent;
	}
	
	
}
