package co.in.DTO;

import java.util.*;

public class CourseDTO 
{


	private Integer courseid, collegeid;
	
	private String coursename;
	
	private Set studentChild;

	
	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public Integer getCollegeid() {
		return collegeid;
	}

	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Set getStudentChild() {
		return studentChild;
	}

	public void setStudentChild(Set studentChild) {
		this.studentChild = studentChild;
	}
	

}
