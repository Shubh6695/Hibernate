package co.in.pp;

public class HusbandDTO 
{

	private Integer hid, hage, hmobile;
	
	private String hname, hgender, hoccupation; 
	
	private WifeDTO wife;
	
		
	
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

	public Integer getHage() {
		return hage;
	}

	public void setHage(Integer hage) {
		this.hage = hage;
	}

	public Integer getHmobile() {
		return hmobile;
	}

	public void setHmobile(Integer hmobile) {
		this.hmobile = hmobile;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getHgender() {
		return hgender;
	}

	public void setHgender(String hgender) {
		this.hgender = hgender;
	}

	public String getHoccupation() {
		return hoccupation;
	}

	public void setHoccupation(String hoccupation) {
		this.hoccupation = hoccupation;
	}

	public WifeDTO getWife() {
		return wife;
	}

	public void setWife(WifeDTO wife) {
		this.wife = wife;
	}
	
	
	
}
