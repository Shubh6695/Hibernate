package co.in.pp;

public class EmployeeDTO 
{

	private Integer eid, mobile, salary;
	
	private String fname, lname, email;

	private DepartmentDTO DepParent;

	
	
	
	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
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

	public DepartmentDTO getDepParent() {
		return DepParent;
	}

	public void setDepParent(DepartmentDTO depParent) {
		DepParent = depParent;
	}
	
	
	
	
	
}
