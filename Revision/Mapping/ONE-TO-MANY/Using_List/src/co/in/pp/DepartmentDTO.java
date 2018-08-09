package co.in.pp;

import java.util.*;

public class DepartmentDTO 
{

	private Integer depid;
	
	private String depname;
	
	
	private List employeeChild;


	public Integer getDepid() {
		return depid;
	}


	public void setDepid(Integer depid) {
		this.depid = depid;
	}


	public String getDepname() {
		return depname;
	}


	public void setDepname(String depname) {
		this.depname = depname;
	}


	public List getEmployeeChild() {
		return employeeChild;
	}


	public void setEmployeeChild(List employeeChild) {
		this.employeeChild = employeeChild;
	}
	
		
}
