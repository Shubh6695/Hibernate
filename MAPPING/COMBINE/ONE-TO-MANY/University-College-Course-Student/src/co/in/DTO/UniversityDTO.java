package co.in.DTO;

import java.util.*;

public class UniversityDTO 
{

	private Integer uid, ucontact;
	
	private String uname, uemail ,ucode;
	
	private Set collegeChild;

	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUcontact() {
		return ucontact;
	}

	public void setUcontact(Integer ucontact) {
		this.ucontact = ucontact;
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

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	public Set getCollegeChild() {
		return collegeChild;
	}

	public void setCollegeChild(Set collegeChild) {
		this.collegeChild = collegeChild;
	}
	
	
}
