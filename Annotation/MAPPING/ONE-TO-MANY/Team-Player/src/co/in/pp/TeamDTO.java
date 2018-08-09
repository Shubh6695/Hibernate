package co.in.pp;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "sportteam")

public class TeamDTO {

	@Id
	@Column(name = "TEAM_ID")
	private Integer teamid;

	@Column(name = "TEAM_NAME")
	private String teamname;

	@Column(name = "TEAM_COUNTRY")
	private String teamcountry;

	@Column(name = "TEAM_SPORT")
	private String teamsport;

	

	@OneToMany(targetEntity=PlayerDTO.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="T_ID", referencedColumnName="TEAM_ID")
	
	private Set playerChild;
	
	
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

	public String getTeamcountry() {
		return teamcountry;
	}

	public void setTeamcountry(String teamcountry) {
		this.teamcountry = teamcountry;
	}

	public String getTeamsport() {
		return teamsport;
	}

	public void setTeamsport(String teamsport) {
		this.teamsport = teamsport;
	}

	public Set getPlayerChild() {
		return playerChild;
	}

	public void setPlayerChild(Set playerChild) {
		this.playerChild = playerChild;
	}

}
