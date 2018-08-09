package co.in.pp;

import java.util.*;

public class ChildrenDTO 
{

	private Integer cid, age, yearofbirth;
	
	private String name, email;
	
	private Set ParentInfo;

	
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getYearofbirth() {
		return yearofbirth;
	}

	public void setYearofbirth(Integer yearofbirth) {
		this.yearofbirth = yearofbirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getParentInfo() {
		return ParentInfo;
	}

	public void setParentInfo(Set parentInfo) {
		ParentInfo = parentInfo;
	}
	
	
}
