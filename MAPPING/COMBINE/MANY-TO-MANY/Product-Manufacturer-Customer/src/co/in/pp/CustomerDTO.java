package co.in.pp;

import java.util.*;

public class CustomerDTO 
{

	private Integer cid, cmobile;
	
	private String cname, cemail;
	
	
	private Set manufacturerParent;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public Integer getCmobile() {
		return cmobile;
	}


	public void setCmobile(Integer cmobile) {
		this.cmobile = cmobile;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public String getCemail() {
		return cemail;
	}


	public void setCemail(String cemail) {
		this.cemail = cemail;
	}


	public Set getManufacturerParent() {
		return manufacturerParent;
	}


	public void setManufacturerParent(Set manufacturerParent) {
		this.manufacturerParent = manufacturerParent;
	}
	
	
	
}
