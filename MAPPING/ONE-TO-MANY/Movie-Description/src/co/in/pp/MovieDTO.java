package co.in.pp;

import  java.util.*;

public class MovieDTO
{

	private Integer movieid, releaseyear;
	
	private String moviename, movietype;
	
	private Float movielength;
	
	private Set MovieChild;


	
	
	public Integer getMovieid() {
		return movieid;
	}


	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}


	public Integer getReleaseyear() {
		return releaseyear;
	}


	public void setReleaseyear(Integer releaseyear) {
		this.releaseyear = releaseyear;
	}


	public String getMoviename() {
		return moviename;
	}


	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}


	public String getMovietype() {
		return movietype;
	}


	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}


	public Float getMovielength() {
		return movielength;
	}


	public void setMovielength(Float movielength) {
		this.movielength = movielength;
	}


	public Set getMovieChild() {
		return MovieChild;
	}


	public void setMovieChild(Set movieChild) {
		MovieChild = movieChild;
	}
	
	
	
}
