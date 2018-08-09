package co.in.pp;

public class UserDTO 
{

	private Integer uid, uage, umobile;
	
	private String uname, uemail;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(Integer uid, Integer uage, Integer umobile, String uname, String uemail) {
		super();
		this.uid = uid;
		this.uage = uage;
		this.umobile = umobile;
		this.uname = uname;
		this.uemail = uemail;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getUage() {
		return uage;
	}

	public void setUage(Integer uage) {
		this.uage = uage;
	}

	public Integer getUmobile() {
		return umobile;
	}

	public void setUmobile(Integer umobile) {
		this.umobile = umobile;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
	
	
}
