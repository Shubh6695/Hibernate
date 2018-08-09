package co.in.pp;

import java.util.*;

public class CityDTO 
{

	private Integer cityid;
	
	private String cityname;
	
	private CountryDTO countryParent;
	
	private StateDTO stateParent;

	
	
	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public CountryDTO getCountryParent() {
		return countryParent;
	}

	public void setCountryParent(CountryDTO countryParent) {
		this.countryParent = countryParent;
	}

	public StateDTO getStateParent() {
		return stateParent;
	}

	public void setStateParent(StateDTO stateParent) {
		this.stateParent = stateParent;
	}

	
}
