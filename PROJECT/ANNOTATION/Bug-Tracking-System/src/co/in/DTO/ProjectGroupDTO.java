package co.in.DTO;

import javax.persistence.*;

@Entity
@Table(name="projectgroup")
public class ProjectGroupDTO 
{

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PROJECT_GROUP_ID")
	private Integer pgid;
	
	
	@Column(name="PROJECT_GROUP_NAME")
	private String pgname;


	public Integer getPgid() {
		return pgid;
	}


	public void setPgid(Integer pgid) {
		this.pgid = pgid;
	}


	public String getPgname() {
		return pgname;
	}


	public void setPgname(String pgname) {
		this.pgname = pgname;
	}
	
	
	
}
