package co.in.pp;

import javax.persistence.*;

@Entity
@Table(name="paymenttableperconcreteclass")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)  

public class PaymentDTO 
{

	@Id
	@Column(name="P_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)  
	
	public Integer pid;
	
	
	
	@Column(name="AMOUNT")
	public Double amount;

	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
