package co.in.pp;

import java.util.*;

public class TrainDTO
{

	
	private Integer tid, tnum;
	
	private String tname, ttype, tsourcestation, tdestinationstation;

	private Set UserChild;

	
	
	
	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Integer getTnum() {
		return tnum;
	}

	public void setTnum(Integer tnum) {
		this.tnum = tnum;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public String getTsourcestation() {
		return tsourcestation;
	}

	public void setTsourcestation(String tsourcestation) {
		this.tsourcestation = tsourcestation;
	}

	public String getTdestinationstation() {
		return tdestinationstation;
	}

	public void setTdestinationstation(String tdestinationstation) {
		this.tdestinationstation = tdestinationstation;
	}

	public Set getUserChild() {
		return UserChild;
	}

	public void setUserChild(Set userChild) {
		UserChild = userChild;
	}
	
	
}
