package co.in.pp;

import java.util.*;

public class DepartmentDTO 
{

	
	private Integer depid;
	
	private String depname;
	
	
	private Set empolyeeChild;


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


	public Set getEmpolyeeChild() {
		return empolyeeChild;
	}


	public void setEmpolyeeChild(Set empolyeeChild) {
		this.empolyeeChild = empolyeeChild;
	}
	
	
	
	
}
