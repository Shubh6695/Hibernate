package co.in.DTO;

import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="employee")

public class EmployeeDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="E_ID")
	private Integer eid;
	
	
	@Column(name="FIRST_NAME")
	private String fname;
	
	
	@Column(name="LAST_NAME")
	private String lname;
	
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="MOBILE")
	private Integer mobile;
	
	
	@Column(name="DATE_OF_BIRTH")
	@Temporal(TemporalType.DATE)
	private Date dateofbirth;
 
	
	@Column(name="ROLE")
	private String role; 
	
	
	@Column(name="T_ID")
	private Integer tid;

	
	@OneToMany(targetEntity=BugStatusDTO.class, cascade=CascadeType.ALL)								// One to Many with BugStatusDTO
	@JoinColumn(name="E_ID", referencedColumnName="E_ID")
	private Set bugStatusChild;



	@ManyToMany(targetEntity = EmployeeMilestoneDTO.class, cascade=CascadeType.ALL  )											// Many to Many with Employee MilestoneDTO
	@JoinTable(name="employeemilestone" , joinColumns=@JoinColumn(name="EMP_ID" , referencedColumnName="E_ID"),
	inverseJoinColumns=@JoinColumn(name="MILE_ID", referencedColumnName="E_M_ID")
)

	private Set employeeparent;
	

	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
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


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Integer getTid() {
		return tid;
	}


	public void setTid(Integer tid) {
		this.tid = tid;
	}


	public Set getBugStatusChild() {
		return bugStatusChild;
	}


	public void setBugStatusChild(Set bugStatusChild) {
		this.bugStatusChild = bugStatusChild;
	}


	public Set getEmployeeparent() {
		return employeeparent;
	}


	public void setEmployeeparent(Set employeeparent) {
		this.employeeparent = employeeparent;
	}
	
	
	
}
