package co.in.pp;


import javax.persistence.*;

@Entity
@Table(name="chequetablepersubclass")
@PrimaryKeyJoinColumn(name="ID")  

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
