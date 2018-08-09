package co.in.pp;

import java.util.*;

public class VendorDTO
{

	private Integer vid;
	
	private String vname;
	
	private Set children;
	
	
	
	
	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public Set getChildren() {
		return children;
	}

	public void setChildren(Set children) {
		this.children = children;
	}


	
}
