package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="chatbug")
public class ChatBugDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="M_ID")
	private Integer mid;
	
	
	
	@Column(name="MESSAGE")
	private String message;
	
	
	@Column(name="SENDER")
	private String sender;
	
	
	@Column(name="MESSAGE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date messagetime;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)																	// Many To One with BugDTO
	@JoinColumn(name="BUG_ID", referencedColumnName="BUG_ID")
	private BugDTO bugChild;
	
	
	@ManyToOne(cascade=CascadeType.ALL)																	// Many To One with EmployeeDTO
	@JoinColumn(name="E_ID", referencedColumnName="E_ID")
	private EmployeeDTO employeeChild;
	
	
	@ManyToOne(cascade=CascadeType.ALL)																	// Many To One with CustomerDTO
	@JoinColumn(name="C_ID", referencedColumnName="C_ID")
	private CustomerDTO customerChild;


	public Integer getMid() {
		return mid;
	}


	public void setMid(Integer mid) {
		this.mid = mid;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getMessagetime() {
		return messagetime;
	}


	public void setMessagetime(Date messagetime) {
		this.messagetime = messagetime;
	}


	public BugDTO getBugChild() {
		return bugChild;
	}


	public void setBugChild(BugDTO bugChild) {
		this.bugChild = bugChild;
	}


	public EmployeeDTO getEmployeeChild() {
		return employeeChild;
	}


	public void setEmployeeChild(EmployeeDTO employeeChild) {
		this.employeeChild = employeeChild;
	}


	public CustomerDTO getCustomerChild() {
		return customerChild;
	}


	public void setCustomerChild(CustomerDTO customerChild) {
		this.customerChild = customerChild;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}

	
}
