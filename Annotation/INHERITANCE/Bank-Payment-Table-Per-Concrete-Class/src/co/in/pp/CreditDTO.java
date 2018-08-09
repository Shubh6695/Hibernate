package co.in.pp;

import javax.persistence.*;


@Entity
@Table(name="credittableperconcreteclass")
@AttributeOverrides
({

	@AttributeOverride(name="pid", column=@Column(name="P_ID")),
	@AttributeOverride(name="amount", column=@Column(name="AMOUNT"))
		
})


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
