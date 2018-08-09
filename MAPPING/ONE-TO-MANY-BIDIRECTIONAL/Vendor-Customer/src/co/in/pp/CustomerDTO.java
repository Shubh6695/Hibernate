package co.in.pp;

public class CustomerDTO 
{

	private Integer customerid, vid;
	
	private String customername; 
	
	
	private VendorDTO vendorParent;


	
	
	public Integer getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}


	public Integer getVid() {
		return vid;
	}


	public void setVid(Integer vid) {
		this.vid = vid;
	}


	public String getCustomername() {
		return customername;
	}


	public void setCustomername(String customername) {
		this.customername = customername;
	}


	public VendorDTO getVendorParent() {
		return vendorParent;
	}


	public void setVendorParent(VendorDTO vendorParent) {
		this.vendorParent = vendorParent;
	}
	
	
}
