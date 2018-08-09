package co.in.pp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
@Table(name="studentinfo")



public class StudentDTO 
{


	
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="S_ID")
	
	private Integer sid;

	
	@Column(name="MOBILE")
	private Integer mobile;
	


	@Column(name="FIRST_NAME")
	
	private String fname;
	
	
	@Column(name="LAST_NAME")
	private String lname;
	
	
	
	@Column(name="EMAIL")
	private String email;

	
	
	
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
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
	
	
	
}
