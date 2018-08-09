package co.in.pp;

import java.util.*;


public class DepartmentDTO 
{

	private Integer departmentid;
	
	private String departmentname;
	
	
	private Set DepartmentChild;


	public Integer getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}


	public String getDepartmentname() {
		return departmentname;
	}


	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}


	public Set getDepartmentChild() {
		return DepartmentChild;
	}


	public void setDepartmentChild(Set departmentChild) {
		DepartmentChild = departmentChild;
	}
	
	
	
	
	
	
	
}
