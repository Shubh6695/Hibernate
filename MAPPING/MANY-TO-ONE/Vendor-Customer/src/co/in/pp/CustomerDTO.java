package co.in.pp;

public class CustomerDTO 
{

	private Integer customerid;
	
	private String customername;
	
	private VendorDTO ParentObject;			// Aggregation(If a class have an entity reference, it is known as Aggregation)
	
	
	public Integer getCustomerid()
	{
		return customerid;
	}
	
	
						public void setCustomerid(Integer customerid)
						{
							this.customerid=customerid;
						}


	public String getCustomername() 
	{
	
		return customername;
	}


						public void setCustomername(String customername) 
						{
							this.customername = customername;
						}


	public VendorDTO getParentObject() 
	{
		return ParentObject;
	}


						public void setParentObject(VendorDTO parentObject) 
						{
							ParentObject = parentObject;
						}
					
	
						
						
						
						
	
	
}
