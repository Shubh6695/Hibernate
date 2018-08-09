package co.in.pp;

public class AuthorDTO 
{

	private Integer authorid;
	
	private String authorfname, authorlname, authoremail;

	
	
	public Integer getAuthorid() {
		return authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	public String getAuthorfname() {
		return authorfname;
	}

	public void setAuthorfname(String authorfname) {
		this.authorfname = authorfname;
	}

	public String getAuthorlname() {
		return authorlname;
	}

	public void setAuthorlname(String authorlname) {
		this.authorlname = authorlname;
	}

	public String getAuthoremail() {
		return authoremail;
	}

	public void setAuthoremail(String authoremail) {
		this.authoremail = authoremail;
	}
	
	
	
}
