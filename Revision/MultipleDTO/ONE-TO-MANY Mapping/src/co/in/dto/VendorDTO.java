package co.in.dto;

import java.util.*;

public class VendorDTO {
	
	private int vendorid;
	
	private String vendorname;
	
	private Set children;

	
	
	
	public int getVendorid() {
		return vendorid;
	}

	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}

			
	public String getVendorname() {
				return vendorname;
			}

			public void setVendorname(String vendorname) {
				this.vendorname = vendorname;
			}

	public Set getChildren()
	{
		return children;
	}
			
			public void setChildren(Set children)
			{
				this.children=children;
			}
			
			
}
