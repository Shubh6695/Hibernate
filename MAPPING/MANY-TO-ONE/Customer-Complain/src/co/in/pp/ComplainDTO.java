package co.in.pp;

public class ComplainDTO 
{

	private Integer complainid;
	
	private String complaindetail, complaintype, complainstatus;

	private CustomerDTO CustomerParent;

	
	
	public Integer getComplainid() {
		return complainid;
	}

	public void setComplainid(Integer complainid) {
		this.complainid = complainid;
	}

	public String getComplaindetail() {
		return complaindetail;
	}

	public void setComplaindetail(String complaindetail) {
		this.complaindetail = complaindetail;
	}

	public String getComplaintype() {
		return complaintype;
	}

	public void setComplaintype(String complaintype) {
		this.complaintype = complaintype;
	}

	public String getComplainstatus() {
		return complainstatus;
	}

	public void setComplainstatus(String complainstatus) {
		this.complainstatus = complainstatus;
	}

	public CustomerDTO getCustomerParent() {
		return CustomerParent;
	}

	public void setCustomerParent(CustomerDTO customerParent) {
		CustomerParent = customerParent;
	}
	
	
	
	
	
	
}
