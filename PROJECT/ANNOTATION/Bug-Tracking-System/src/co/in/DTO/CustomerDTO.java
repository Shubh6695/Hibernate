package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="customer")
public class CustomerDTO
{

	
	@Id
	@Column(name="C_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	
	
	@Column(name="FIRST_NAME")
	private String fname;
	
	
	@Column(name="LAST_NAME")
	private String lname;
	
	
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
	
	
	@Column(name="GENDER")
	private String gender;
	
	
	@Column(name="MOBILE")
	private Integer mobile;
	
	
	@Column(name="ADDRESS")
	private String address;

	
	@OneToMany(targetEntity=ProjectDTO.class, cascade=CascadeType.ALL)				// One to Many with ProjectDTO	
	@JoinColumn(name="CUS_ID", referencedColumnName="C_ID")
	
	private Set projectChild;
	
	
	
	
	@OneToOne(mappedBy = "customerParent")											// One to One mapping with LoginDTO
	

	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
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


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set getProjectChild() {
		return projectChild;
	}


	public void setProjectChild(Set projectChild) {
		this.projectChild = projectChild;
	}
	
		
}
