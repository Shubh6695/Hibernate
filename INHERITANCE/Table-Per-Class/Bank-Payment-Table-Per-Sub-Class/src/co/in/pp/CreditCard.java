package co.in.pp;

public class CreditCard extends Payment
{
	private Integer cid;
	
	public String creditCardType;


	public String getCreditCardType() 
	{
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) 
	{
		this.creditCardType = creditCardType;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	} 
	
	
	
	
	
	
}
