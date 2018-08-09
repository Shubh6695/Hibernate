package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="bugs")
public class BugDTO
{

	@Id
	@Column(name="BUG_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bugid;
	
	
	@Column(name="BUG_NAME")
	private String bugname;
	
	
	@Column(name="BUG_DESCRIPTION")
	private String bugdescription;
	
	
	@Column(name="BUG_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date bugstartdate;
	
	
	@Column(name="BUG_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date bugenddate;
	
	
	@Column(name="PROJECT_ID")
	private Integer projectid;
	
	
	@OneToOne(cascade = CascadeType.ALL)												//One to One with BugStatusDTO
	@PrimaryKeyJoinColumn	
	private BugStatusDTO bugstatusChild;
	
/*	@ManyToOne(targetEntity=ProjectDTO.class ,cascade=CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID", referencedColumnName="P_ID")

	private ProjectDTO projectParent;
*/

	
	@OneToOne(mappedBy = "bugParent")
	
	@OneToMany(mappedBy ="bugChild")												// One to Many With ProjectDTO
	
	public Integer getBugid() {
		return bugid;
	}



	public void setBugid(Integer bugid) {
		this.bugid = bugid;
	}



	public String getBugname() {
		return bugname;
	}



	public void setBugname(String bugname) {
		this.bugname = bugname;
	}



	public String getBugdescription() {
		return bugdescription;
	}



	public void setBugdescription(String bugdescription) {
		this.bugdescription = bugdescription;
	}



	public Date getBugstartdate() {
		return bugstartdate;
	}



	public void setBugstartdate(Date bugstartdate) {
		this.bugstartdate = bugstartdate;
	}



	public Date getBugenddate() {
		return bugenddate;
	}



	public void setBugenddate(Date bugenddate) {
		this.bugenddate = bugenddate;
	}


/*
	public ProjectDTO getProjectParent() {
		return projectParent;
	}



	public void setProjectParent(ProjectDTO projectParent) {
		this.projectParent = projectParent;
	}
*/


	public Integer getProjectid() {
		return projectid;
	}



	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}



	public BugStatusDTO getBugstatusChild() {
		return bugstatusChild;
	}



	public void setBugstatusChild(BugStatusDTO bugstatusChild) {
		this.bugstatusChild = bugstatusChild;
	}
	
	
	
	
}
