package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="projectmilestone")
public class ProjectMilestoneDTO 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="P_M_ID")
	private Integer pmid;
	
	
	
	@Column(name="P_M_NAME")
	private String pmname;
	
	
	
	@Column(name="P_M_START_DATE")
	@Temporal(TemporalType.DATE)
	private Date pmstartdate;
	
	
	@Column(name="P_M_END_DATE")
	@Temporal(TemporalType.DATE)
	private Date pmenddate;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)																// Many to One with ProjectDTO
	@JoinColumn(name="PROJECT_ID", referencedColumnName="P_ID")
	
	private ProjectDTO projectParent;



	public Integer getPmid() {
		return pmid;
	}



	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}



	public String getPmname() {
		return pmname;
	}



	public void setPmname(String pmname) {
		this.pmname = pmname;
	}



	public Date getPmstartdate() {
		return pmstartdate;
	}



	public void setPmstartdate(Date pmstartdate) {
		this.pmstartdate = pmstartdate;
	}



	public Date getPmenddate() {
		return pmenddate;
	}



	public void setPmenddate(Date pmenddate) {
		this.pmenddate = pmenddate;
	}



	public ProjectDTO getProjectParent() {
		return projectParent;
	}



	public void setProjectParent(ProjectDTO projectParent) {
		this.projectParent = projectParent;
	}
	
	
	
}
