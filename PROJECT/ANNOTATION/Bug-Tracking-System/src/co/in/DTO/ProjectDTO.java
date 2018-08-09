package co.in.DTO;

import java.util.*;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;


@Entity
@Table(name="project")

@FilterDef(name = "projectidequal", parameters = { @ParamDef(name = "id", type = "int") })
@Filter(name = "projectidequal", condition = "P_ID= :id ")

public class ProjectDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="P_ID")	
	private Integer pid;
	
	
	@Column(name="P_NAME")
	private String pname;
	
	
	@Column(name="DESCRIPTION")
	private String description;
	
	
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startdate;
	
	
	@Column(name="END_DATE")	
	@Temporal(TemporalType.DATE)
	private Date enddate;
	
	@Column(name="CUS_ID")
	private Integer cusid;
	

	@OneToMany(targetEntity=BugDTO.class, cascade=CascadeType.ALL )							// One to Many with BugDTO
	@JoinColumn(name="PROJECT_ID", referencedColumnName="P_ID")

	private Set bugChild;
	
	
	@OneToOne(cascade = CascadeType.ALL)													// One to One with ProjectStatusDTO
	@PrimaryKeyJoinColumn	
	private StatusDTO statusChild;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)														// Many to One with ProjectGroupDTO			
	@JoinColumn(name="PG_ID", referencedColumnName="PROJECT_GROUP_ID" )
	
	private ProjectGroupDTO projectgroupParent;

	
	@OneToOne(mappedBy = "projectParent")
	
	@OneToMany(mappedBy ="projectChild")

	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getStartdate() {
		return startdate;
	}


	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}


	public Date getEnddate() {
		return enddate;
	}


	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}


	public ProjectGroupDTO getProjectgroupParent() {
		return projectgroupParent;
	}


	public void setProjectgroupParent(ProjectGroupDTO projectgroupParent) {
		this.projectgroupParent = projectgroupParent;
	}


	public Integer getCusid() {
		return cusid;
	}


	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}


	public Set getBugChild() {
		return bugChild;
	}


	public void setBugChild(Set bugChild) {
		this.bugChild = bugChild;
	}


	public StatusDTO getStatusChild() {
		return statusChild;
	}


	public void setStatusChild(StatusDTO statusChild) {
		this.statusChild = statusChild;
	}
	
	
	
	
}
