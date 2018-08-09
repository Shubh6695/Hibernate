package co.in.pp;

import java.util.*;

public class ParentDTO 
{

	private Integer pid, page, pmobile;
	
	private String pname, pgender; 
	
	private Set ChildrenInfo;

	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPmobile() {
		return pmobile;
	}

	public void setPmobile(Integer pmobile) {
		this.pmobile = pmobile;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPgender() {
		return pgender;
	}

	public void setPgender(String pgender) {
		this.pgender = pgender;
	}

	public Set getChildrenInfo() {
		return ChildrenInfo;
	}

	public void setChildrenInfo(Set childrenInfo) {
		ChildrenInfo = childrenInfo;
	}
	
	
}
