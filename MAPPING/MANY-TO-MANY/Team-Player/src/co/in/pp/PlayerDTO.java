package co.in.pp;

import java.util.*;

public class PlayerDTO 
{

	
	private Integer pid, pmobile ,page;
	
	private String pname, pemail, paddress;

	
	private Set TeamParent;


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public Integer getPmobile() {
		return pmobile;
	}


	public void setPmobile(Integer pmobile) {
		this.pmobile = pmobile;
	}


	public Integer getPage() {
		return page;
	}


	public void setPage(Integer page) {
		this.page = page;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPemail() {
		return pemail;
	}


	public void setPemail(String pemail) {
		this.pemail = pemail;
	}


	public String getPaddress() {
		return paddress;
	}


	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}


	public Set getTeamParent() {
		return TeamParent;
	}


	public void setTeamParent(Set teamParent) {
		TeamParent = teamParent;
	}
	
	
	
}
