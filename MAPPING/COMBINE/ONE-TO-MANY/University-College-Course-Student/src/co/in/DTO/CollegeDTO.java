package co.in.DTO;

import java.util.*;

public class CollegeDTO 
{

	private Integer cid, ccontact, uid;
	
	private String cname, cemail, cgrade;

	private Set courseChild;
	
	
	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCcontact() {
		return ccontact;
	}

	public void setCcontact(Integer ccontact) {
		this.ccontact = ccontact;
	}

	
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCgrade() {
		return cgrade;
	}

	public void setCgrade(String cgrade) {
		this.cgrade = cgrade;
	}

	public Set getCourseChild() {
		return courseChild;
	}

	public void setCourseChild(Set courseChild) {
		this.courseChild = courseChild;
	}
	
	
	
}
