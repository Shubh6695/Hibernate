package co.in.DTO;

public class StudentDTO 
{

	private Integer sid, smobile;
	
	private String sname, semail, sgender;
	
	
	private AddressDTO AddressChild;

	

	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public Integer getSmobile() {
		return smobile;
	}


	public void setSmobile(Integer smobile) {
		this.smobile = smobile;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSemail() {
		return semail;
	}


	public void setSemail(String semail) {
		this.semail = semail;
	}


	public String getSgender() {
		return sgender;
	}


	public void setSgender(String sgender) {
		this.sgender = sgender;
	}


	public AddressDTO getAddressChild() {
		return AddressChild;
	}


	public void setAddressChild(AddressDTO addressChild) {
		AddressChild = addressChild;
	}


}
