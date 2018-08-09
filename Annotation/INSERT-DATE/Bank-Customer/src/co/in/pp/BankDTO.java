package co.in.pp;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="bankdetails")

public class BankDTO 
{
	@Id
	@Column(name="BANK_ID")
	private Integer bankid;
	
	
	@Column(name="BANK_NAME")
	private String bankname;
	
	
	@Column(name="BANK_EMAIL")
	private String bankemail;
	
	
	@Column(name="BANK_ADDRESS")
	private String bankaddress;
	
	
	@Column(name="BANK_CONTACT")
	private Integer bankcontact;	
	
	

	@OneToMany(targetEntity=CustomerDTO.class, cascade=CascadeType.ALL)
	@JoinColumn(name="B_ID", referencedColumnName="BANK_ID")	
	
	private Set customerChild;



	public Integer getBankid() {
		return bankid;
	}



	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}



	public String getBankname() {
		return bankname;
	}



	public void setBankname(String bankname) {
		this.bankname = bankname;
	}



	public String getBankemail() {
		return bankemail;
	}



	public void setBankemail(String bankemail) {
		this.bankemail = bankemail;
	}



	public String getBankaddress() {
		return bankaddress;
	}



	public void setBankaddress(String bankaddress) {
		this.bankaddress = bankaddress;
	}



	public Integer getBankcontact() {
		return bankcontact;
	}



	public void setBankcontact(Integer bankcontact) {
		this.bankcontact = bankcontact;
	}



	public Set getCustomerChild() {
		return customerChild;
	}



	public void setCustomerChild(Set customerChild) {
		this.customerChild = customerChild;
	}
	
	
	
}
