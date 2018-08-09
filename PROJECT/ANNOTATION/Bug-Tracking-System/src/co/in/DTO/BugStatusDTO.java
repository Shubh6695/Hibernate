package co.in.DTO;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="bugstatus")
public class BugStatusDTO 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="S_ID")
	private Integer sid;
	
	
	@Column(name="BUG_NAME")
	private String bugname;
	
	
	@Column(name="STATUS")
	private String status;
	
	
	@Column(name="SUBMISSION_DATE")
	private Date submissiondate;
	
	
	@Column(name="E_ID")
	private Integer eid;
	
	
	@OneToOne(mappedBy = "bugstatusChild")													//One to One with BugDTO
	
/*	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn	
	private BugDTO bugParent;

*/	
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}



	public String getBugname() {
		return bugname;
	}


	public void setBugname(String bugname) {
		this.bugname = bugname;
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


/*	public BugDTO getBugParent() {
		return bugParent;
	}


	public void setBugParent(BugDTO bugParent) {
		this.bugParent = bugParent;
	}
*/

	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}

	
	
}
