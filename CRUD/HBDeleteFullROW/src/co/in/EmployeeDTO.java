package co.in;

public class EmployeeDTO {

	
	private int id, pincode;
	
	private String fname, lname, address ;
	
	private long mobile;


			
		
	
	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}



	public int getPincode()
	{
		return pincode;
	}
	
	



			public void setPincode(int pincode)
			{
				this.pincode=pincode;
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
	
	
	

	public long getMobile()
	{
		return mobile;
	}
			
	
			public void setMobile(long mobile)
			{
				this.mobile=mobile;
			}
			
}
