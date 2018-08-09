package co.in;

public class StudentDTO {

	private int id;
	
	private String userid, password, fname, lname, address;
	
	
	public int getId()
	{
		return id;
	}
	
			public void setId(int id)
			{
				this.id=id;
			}
	
	public String getUserid()		
	{
		return userid;
	}
	
			public void setUserid(String userid)
			{
				this.userid=userid;
			}
			
	
	public String getPassword()
	{
		return password;
	}
	
			public void setPassword(String password)
			{
				this.password=password;
			}
			
	public String getFname()
	{
		return fname;
	}
	
			public void setFname(String fname)
			{
				this.fname=fname;
			}
			
	public String getLname()
	{
		return lname;
	}
	
	
			public void setLname(String lname)
			{
				this.lname=lname;
			}
	
	
	public String getAddress()
	{
		return address;
	}
			public void setAddress(String address)
			{
				this.address=address;
			}
			
}
