package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="empmilestone")
public class EmployeeMilestoneDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="E_M_ID")
	private Integer emid;
	
	
	@Column(name="E_M_NAME")
	private String emname;
	
	
	@Column(name="E_M_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date emstartdate;
	
	
	@Column(name="E_M_DATE_DATE")
	@Temporal(TemporalType.DATE)
	private Date emenddate;
	
	
	
	@ManyToMany(targetEntity=EmployeeDTO.class, cascade=CascadeType.ALL)																			// Many to Many with EmployeeDTO	
	@JoinTable(name="employeemilestone" , joinColumns=@JoinColumn(name="MILE_ID" , referencedColumnName="E_M_ID"),
	inverseJoinColumns=@JoinColumn(name="EMP_ID", referencedColumnName="E_ID")
)

	
	private Set employeechild;



	public Integer getEmid() {
		return emid;
	}



	public void setEmid(Integer emid) {
		this.emid = emid;
	}



	public String getEmname() {
		return emname;
	}



	public void setEmname(String emname) {
		this.emname = emname;
	}



	public Date getEmstartdate() {
		return emstartdate;
	}



	public void setEmstartdate(Date emstartdate) {
		this.emstartdate = emstartdate;
	}



	public Date getEmenddate() {
		return emenddate;
	}



	public void setEmenddate(Date emenddate) {
		this.emenddate = emenddate;
	}



	public Set getEmployeechild() {
		return employeechild;
	}



	public void setEmployeechild(Set employeechild) {
		this.employeechild = employeechild;
	}
	
	
	
	
}
