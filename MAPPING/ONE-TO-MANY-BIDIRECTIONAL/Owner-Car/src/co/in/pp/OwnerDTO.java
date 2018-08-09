package co.in.pp;

import java.util.*;


public class OwnerDTO 
{

	private Integer ownerid, ownermobile;
	
	private String ownername, ownergender,  owneremail;
	
	
	private Set CarChild;

	

	public Integer getOwnerid() {
		return ownerid;
	}


	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}


	public Integer getOwnermobile() {
		return ownermobile;
	}


	public void setOwnermobile(Integer ownermobile) {
		this.ownermobile = ownermobile;
	}


	public String getOwnername() {
		return ownername;
	}


	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}


	public String getOwnergender() {
		return ownergender;
	}


	public void setOwnergender(String ownergender) {
		this.ownergender = ownergender;
	}


	public String getOwneremail() {
		return owneremail;
	}


	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}


	public Set getCarChild() {
		return CarChild;
	}


	public void setCarChild(Set carChild) {
		CarChild = carChild;
	}


	
}
