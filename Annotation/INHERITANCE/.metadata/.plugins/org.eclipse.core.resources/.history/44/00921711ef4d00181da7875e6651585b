package co.in.pp;


import javax.persistence.*;

@Entity
@DiscriminatorValue("cheque")

public class ChequeDTO extends PaymentDTO
{

	@Column(name="CHEQUE_TYPE")
	public String chequeType;

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	
}
