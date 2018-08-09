package co.in.pp;


import javax.persistence.*;

@Entity
@Table(name="chequetableperconcreteclass")
@AttributeOverrides
({

	@AttributeOverride(name="pid", column=@Column(name="P_ID")),
	@AttributeOverride(name="amount", column=@Column(name="AMOUNT"))
		
})


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
