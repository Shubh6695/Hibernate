package co.in.DTO;

public class AddressDTO 
{

	
	private Integer aid, pincode;
	
	private String city, state, country;
	
	private StudentDTO studentParent;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public StudentDTO getStudentParent() {
		return studentParent;
	}

	public void setStudentParent(StudentDTO studentParent) {
		this.studentParent = studentParent;
	}
	
	
	
	
}
