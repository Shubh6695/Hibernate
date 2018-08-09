package co.in.pp;

import java.util.*;

public class StateDTO 
{

	private Integer stateid;
	
	private String statename;
	
	private Set cityParentDemo;														// It is child
	
	
	
	public Integer getStateid() {
		return stateid;
	}

	public void setStateid(Integer stateid) {
		this.stateid = stateid;
	}

	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public Set getCityParentDemo() {
		return cityParentDemo;
	}

	public void setCityParentDemo(Set cityParentDemo) {
		this.cityParentDemo = cityParentDemo;
	}

	
	
	
}
