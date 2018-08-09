package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="projectstatus")
public class StatusDTO 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="S_ID")
	private Integer sid;
	
	
	@Column(name="PROJECT_NAME")
	private String projectname;
	
	
	@Column(name="STATUS")
	private String status;
	
	
	@Column(name="SUBMISSION_DATE")
	@Temporal(TemporalType.DATE)
	private Date submissiondate;
	
	
	@Column(name="T_ID")
	private Integer tid;
	
	
	
	
/*	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn	
	private ProjectDTO projectParent;
*/

/*	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="T_ID", referencedColumnName="TEAM_ID")

	private TeamDTO teamParent;
*/


	@OneToOne(mappedBy = "statusChild")																		// One to One mapping with ProjectDTO
	
	
	public Integer getSid() {
		return sid;
	}



	public void setSid(Integer sid) {
		this.sid = sid;
	}



	public String getProjectname() {
		return projectname;
	}



	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}




	public Date getSubmissiondate() {
		return submissiondate;
	}



	public void setSubmissiondate(Date submissiondate) {
		this.submissiondate = submissiondate;
	}



/*	public ProjectDTO getProjectParent() {
		return projectParent;
	}



	public void setProjectParent(ProjectDTO projectParent) {
		this.projectParent = projectParent;
	}
*/


	public Integer getTid() {
		return tid;
	}



	public void setTid(Integer tid) {
		this.tid = tid;
	}




/*	public TeamDTO getTeamParent() {
		return teamParent;
	}



	public void setTeamParent(TeamDTO teamParent) {
		this.teamParent = teamParent;
	}
*/	


	
	
	
	
}
