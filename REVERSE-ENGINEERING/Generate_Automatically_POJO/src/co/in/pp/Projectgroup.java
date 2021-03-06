package co.in.pp;
// Generated May 31, 2018 7:25:50 PM by Hibernate Tools 3.5.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Projectgroup generated by hbm2java
 */
@Entity
@Table(name = "projectgroup", catalog = "hibernate_project_annotation")
public class Projectgroup implements java.io.Serializable {

	private Integer projectGroupId;
	private String projectGroupName;
	private Set<Project> projects = new HashSet<Project>(0);

	public Projectgroup() {
	}

	public Projectgroup(String projectGroupName, Set<Project> projects) {
		this.projectGroupName = projectGroupName;
		this.projects = projects;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PROJECT_GROUP_ID", unique = true, nullable = false)
	public Integer getProjectGroupId() {
		return this.projectGroupId;
	}

	public void setProjectGroupId(Integer projectGroupId) {
		this.projectGroupId = projectGroupId;
	}

	@Column(name = "PROJECT_GROUP_NAME")
	public String getProjectGroupName() {
		return this.projectGroupName;
	}

	public void setProjectGroupName(String projectGroupName) {
		this.projectGroupName = projectGroupName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectgroup")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
