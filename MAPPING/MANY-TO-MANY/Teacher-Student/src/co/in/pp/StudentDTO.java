package co.in.pp;

import java.util.*;

public class StudentDTO 
{

	
	private Integer studentid, mobile; 

	private String fname, lname, address ;

	private Set TeacherParent;

	
	
	public Integer getStudentid() {
		return studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set getTeacherParent() {
		return TeacherParent;
	}

	public void setTeacherParent(Set teacherParent) {
		TeacherParent = teacherParent;
	}
	
	
	
}
