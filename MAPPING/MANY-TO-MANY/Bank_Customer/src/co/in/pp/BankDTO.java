package co.in.pp;

import java.util.*;

public class BankDTO 
{

	
	private Integer bankid, bankcontact;
	
	private String bankname, bankemail, bankaddress;

	private Set CustomerChild;

	
	public Integer getBankid() {
		return bankid;
	}

	public void setBankid(Integer bankid) {
		this.bankid = bankid;
	}

	public Integer getBankcontact() {
		return bankcontact;
	}

	public void setBankcontact(Integer bankcontact) {
		this.bankcontact = bankcontact;
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

	public Set getCustomerChild() {
		return CustomerChild;
	}

	public void setCustomerChild(Set customerChild) {
		CustomerChild = customerChild;
	}
	
	
}
