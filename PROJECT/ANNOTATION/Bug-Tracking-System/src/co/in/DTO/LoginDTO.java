package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="login")
public class LoginDTO
{

	@Id
	@Column(name="L_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@Column(name="LOGIN_EMAIL")
	private String loginemail;
	
	
	@Column(name="PASSWORD")
	private String password;
	
	
	@Column(name="ALTERNATE_PASSWORD")
	private String altenatepassword;
	
	
	@Column(name="ACCOUNT_CREATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date accountcreationdate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private CustomerDTO customerParent;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLoginemail() {
		return loginemail;
	}


	public void setLoginemail(String loginemail) {
		this.loginemail = loginemail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAltenatepassword() {
		return altenatepassword;
	}


	public void setAltenatepassword(String altenatepassword) {
		this.altenatepassword = altenatepassword;
	}


	public Date getAccountcreationdate() {
		return accountcreationdate;
	}


	public void setAccountcreationdate(Date accountcreationdate) {
		this.accountcreationdate = accountcreationdate;
	}


	public CustomerDTO getCustomerParent() {
		return customerParent;
	}


	public void setCustomerParent(CustomerDTO customerParent) {
		this.customerParent = customerParent;
	}
	
	
}
