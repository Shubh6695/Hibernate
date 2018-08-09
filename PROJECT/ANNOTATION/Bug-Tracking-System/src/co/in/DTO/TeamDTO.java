package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="team")
public class TeamDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEAM_ID")
	private Integer teamid;
	
	
	@Column(name="TEAM_NAME")
	private String teamname;
	
	
	@Column(name="TEAM_LEAD_NAME")
	private String teamleadname;
	
	
	@OneToMany(targetEntity=EmployeeDTO.class, cascade=CascadeType.ALL)									// One to Many with EmployeeDTO
	@JoinColumn(name="T_ID", referencedColumnName="TEAM_ID")
	private Set employeeChild;

	
	@OneToMany(targetEntity=StatusDTO.class, cascade=CascadeType.ALL)									// One to Many with StatusDTO(Project Status)		
	@JoinColumn(name="T_ID", referencedColumnName="TEAM_ID")
	private Set statusChild;


	public Integer getTeamid() {
		return teamid;
	}


	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}


	public String getTeamname() {
		return teamname;
	}


	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}


	public String getTeamleadname() {
		return teamleadname;
	}


	public void setTeamleadname(String teamleadname) {
		this.teamleadname = teamleadname;
	}


	public Set getEmployeeChild() {
		return employeeChild;
	}


	public void setEmployeeChild(Set employeeChild) {
		this.employeeChild = employeeChild;
	}
	
	
	
}
