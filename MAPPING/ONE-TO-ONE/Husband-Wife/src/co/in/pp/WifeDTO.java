package co.in.pp;

public class WifeDTO 
{

	
	private Integer wid, wage, wmobile;
	
	private String wfname, wlname, wgender;
	
	private HusbandDTO HusbandParent;


	
	
	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getWage() {
		return wage;
	}

	public void setWage(Integer wage) {
		this.wage = wage;
	}

	public Integer getWmobile() {
		return wmobile;
	}

	public void setWmobile(Integer wmobile) {
		this.wmobile = wmobile;
	}

	public String getWfname() {
		return wfname;
	}

	public void setWfname(String wfname) {
		this.wfname = wfname;
	}

	public String getWlname() {
		return wlname;
	}

	public void setWlname(String wlname) {
		this.wlname = wlname;
	}

	public String getWgender() {
		return wgender;
	}

	public void setWgender(String wgender) {
		this.wgender = wgender;
	}

	public HusbandDTO getHusbandParent() {
		return HusbandParent;
	}

	public void setHusbandParent(HusbandDTO husbandParent) {
		HusbandParent = husbandParent;
	}
	
	
	
}
