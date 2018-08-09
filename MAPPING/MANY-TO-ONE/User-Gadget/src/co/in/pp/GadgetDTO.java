package co.in.pp;

public class GadgetDTO 
{

	private Integer gid, gyearofpurchase;
	
	private String gname, gbrand;
	
	private UserDTO UserParent;			// Aggregation(If a class have an entity reference, it is known as Aggregation)

	public GadgetDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GadgetDTO(Integer gid, Integer gyearofpurchase, String gname, String gbrand, UserDTO userParent) {
		super();
		this.gid = gid;
		this.gyearofpurchase = gyearofpurchase;
		this.gname = gname;
		this.gbrand = gbrand;
		UserParent = userParent;
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

	public UserDTO getUserParent() {
		return UserParent;
	}

	public void setUserParent(UserDTO userParent) {
		UserParent = userParent;
	}
	
	
	
	
	
	
}
