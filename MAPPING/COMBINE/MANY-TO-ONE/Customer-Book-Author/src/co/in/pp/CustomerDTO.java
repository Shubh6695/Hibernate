package co.in.pp;

public class CustomerDTO 
{

	private Integer cid;
	
	private String cfname, clname, cemail, ctype;
	
	private BookDTO bookParent;

	
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getClname() {
		return clname;
	}

	public void setClname(String clname) {
		this.clname = clname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public BookDTO getBookParent() {
		return bookParent;
	}

	public void setBookParent(BookDTO bookParent) {
		this.bookParent = bookParent;
	}

	
	
	
}
