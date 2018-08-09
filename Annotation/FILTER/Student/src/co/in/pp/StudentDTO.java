package co.in.pp;

import javax.persistence.*;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.ParamDef;


@Entity
@Table(name="studentinfowithannotation")
/*@FilterDefs
({

	@FilterDef(name="firstnamelike", defaultCondition="FIRST_NAME like :first", parameters= { @ParamDef(name="first", type="String") }),
		
	@FilterDef(name="agegreaterthan", defaultCondition="AGE > :a" ,parameters= { @ParamDef(name="a", type="int") })

})
*/


public class StudentDTO 
{

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="S_ID")
	private Integer sid;
	
	
	@Column(name="FIRST_NAME")
	private String fname;
	
	
	@Column(name="LAST_NAME")
	private String lname;
	
	
	@Column(name="EMAIL")
	private String email;
	
	
	@Column(name="AGE")
	private Integer age;
	
	
	@Column(name="MOBILE")
	private Integer mobile;


	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
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


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getMobile() {
		return mobile;
	}


	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	
	

	
	
}
