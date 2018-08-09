package co.in.pp;

import java.util.*;

public class CountryDTO 
{

	private Integer countryid;
	
	private String countryname;
	
	private Set cityChild;

	
	
	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public Set getCityChild() {
		return cityChild;
	}

	public void setCityChild(Set cityChild) {
		this.cityChild = cityChild;
	}
	
	
	
}
