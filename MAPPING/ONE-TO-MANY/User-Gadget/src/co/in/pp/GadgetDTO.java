package co.in.pp;

public class GadgetDTO 
{

	private Integer gid, gyearofpurchase, uid;
	
	private String gname, gbrand;

	
	
	public GadgetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GadgetDTO(Integer gid, Integer gyearofpurchase, Integer uid, String gname, String gbrand) {
		super();
		this.gid = gid;
		this.gyearofpurchase = gyearofpurchase;
		this.uid = uid;
		this.gname = gname;
		this.gbrand = gbrand;
	}

	
	
	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGyearofpurchase() {
		return gyearofpurchase;
	}

	public void setGyearofpurchase(Integer gyearofpurchase) {
		this.gyearofpurchase = gyearofpurchase;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGbrand() {
		return gbrand;
	}

	public void setGbrand(String gbrand) {
		this.gbrand = gbrand;
	}

	

}
