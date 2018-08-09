package co.in.pp;

import javax.persistence.*;

@Entity
@Table(name="sportplayer")
public class PlayerDTO 
{
	
	@Id
	@Column(name="P_ID")
	private Integer pid;

	
	@Column(name="P_NAME")
	private String pname;
	
	
	@Column(name="P_EMAIL")
	private String pemail;
	
	
	@Column(name="P_ADDRESS")
	private String paddress;
	
	
	@Column(name="P_MOBILE")
	private Integer pmobile;
	
	
	@Column(name="P_AGE")	
	private Integer page;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL , fetch=FetchType.EAGER)
	@JoinColumn(name="T_ID", referencedColumnName="TEAM_ID")
	
	
	private TeamDTO teamParent;



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



	public String getPemail() {
		return pemail;
	}



	public void setPemail(String pemail) {
		this.pemail = pemail;
	}



	public String getPaddress() {
		return paddress;
	}



	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}



	public Integer getPmobile() {
		return pmobile;
	}



	public void setPmobile(Integer pmobile) {
		this.pmobile = pmobile;
	}



	public Integer getPage() {
		return page;
	}



	public void setPage(Integer page) {
		this.page = page;
	}



	public TeamDTO getTeamParent() {
		return teamParent;
	}



	public void setTeamParent(TeamDTO teamParent) {
		this.teamParent = teamParent;
	} 
	
	
	
}
