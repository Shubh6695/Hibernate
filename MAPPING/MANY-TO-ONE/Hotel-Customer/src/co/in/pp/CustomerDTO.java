package co.in.pp;

public class CustomerDTO 
{

	private Integer cid, mobile, roomno;
	
	private String fname, lname, email, address;


	private HotelDTO HotelParent;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public Integer getRoomno() {
		return roomno;
	}


	public void setRoomno(Integer roomno) {
		this.roomno = roomno;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public HotelDTO getHotelParent() {
		return HotelParent;
	}


	public void setHotelParent(HotelDTO hotelParent) {
		HotelParent = hotelParent;
	}
	
	
	
	
	
}
