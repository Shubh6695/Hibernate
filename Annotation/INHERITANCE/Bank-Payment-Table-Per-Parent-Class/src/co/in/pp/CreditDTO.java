package co.in.pp;

import javax.persistence.*;


@Entity
@DiscriminatorValue("credit")

public class CreditDTO extends PaymentDTO
{

	@Column(name="CREDIT_TYPE")
	public String creditCardType;


	public String getCreditCardType() 
	{
		return creditCardType;
	}

	public void setCreditCardType(String creditCardType) 
	{
		this.creditCardType = creditCardType;
	}


	
	
}
