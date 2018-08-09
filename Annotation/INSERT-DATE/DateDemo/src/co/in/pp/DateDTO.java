package co.in.pp;

import java.util.*;
import java.text.*;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="datedemo")

public class DateDTO 
{

	@Id
	@Column(name="ID")
	private Integer id;
	
	
	@Column(name="NAME")
	private String name;
	
	
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)																	// Used for Store Only Date	
	private Date startdate;
	
	
	@Column(name="END_DATE")
	@Temporal(TemporalType.DATE)
	private Date enddate;

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

	
	
	
}
