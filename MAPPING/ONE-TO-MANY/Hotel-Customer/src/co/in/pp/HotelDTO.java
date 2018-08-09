package co.in.pp;

import java.util.*;

public class HotelDTO
{

	private Integer hotelid, hotelcontact;
	
	private String hotelname, hotelcity, hotelemail;
	
	private Float hotelrating;

	
	private Set HotelChild;
	
	
	public Integer getHotelid() {
		return hotelid;
	}

	public void setHotelid(Integer hotelid) {
		this.hotelid = hotelid;
	}

	public Integer getHotelcontact() {
		return hotelcontact;
	}

	public void setHotelcontact(Integer hotelcontact) {
		this.hotelcontact = hotelcontact;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getHotelcity() {
		return hotelcity;
	}

	public void setHotelcity(String hotelcity) {
		this.hotelcity = hotelcity;
	}

	public String getHotelemail() {
		return hotelemail;
	}

	public void setHotelemail(String hotelemail) {
		this.hotelemail = hotelemail;
	}

	public Float getHotelrating() {
		return hotelrating;
	}

	public void setHotelrating(Float hotelrating) {
		this.hotelrating = hotelrating;
	}

	public Set getHotelChild() {
		return HotelChild;
	}

	public void setHotelChild(Set hotelChild) {
		HotelChild = hotelChild;
	}
	
	
	
	
	
}
