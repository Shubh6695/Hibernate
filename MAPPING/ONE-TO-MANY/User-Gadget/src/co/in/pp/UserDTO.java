package co.in.pp;

import java.util.*;


public class UserDTO
{

	
	private Integer uid, umobile, uage;
	
	private String uname,uemail;
	
	private Set GadgetChild;


	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserDTO(Integer uid, Integer umobile, String uname, String uemail, Integer uage) {
		super();
		this.uid = uid;
		this.umobile = umobile;
		this.uname = uname;
		this.uemail = uemail;
		this.uage = uage;
		
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public Integer getUmobile() {
		return umobile;
	}


	public void setUmobile(Integer umobile) {
		this.umobile = umobile;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public Integer getUage() {
		return uage;
	}


	public void setUage(Integer uage) {
		this.uage = uage;
	}


	public Set getGadgetChild() {
		return GadgetChild;
	}


	public void setGadgetChild(Set gadgetChild) {
		GadgetChild = gadgetChild;
	}

	
}
