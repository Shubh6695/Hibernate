package co.in.pp;

import java.util.*;

public class VendorDTO 
{

	private Integer vendorid;
	
	private String vendorname;
	
	
	private Set CustomerChild;														// In Both class Set is used
	
																					// Reason Both Parent/Child hold multiple Child/Parent.


	
	public Integer getVendorid() {
		return vendorid;
	}


	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}


	public String getVendorname() {
		return vendorname;
	}


	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}


	public Set getCustomerChild() {
		return CustomerChild;
	}


	public void setCustomerChild(Set customerChild) {
		CustomerChild = customerChild;
	}
	
	
}
