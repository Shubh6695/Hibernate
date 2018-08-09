package co.in.pp;

import java.util.*;

public class SongsDTO 
{

	private Integer songid;
	
	private String songname, songmovie;
	
	private Float songlength;

	
	private Set SingerParent;

	

	public Integer getSongid() {
		return songid;
	}


	public void setSongid(Integer songid) {
		this.songid = songid;
	}


	public String getSongname() {
		return songname;
	}


	public void setSongname(String songname) {
		this.songname = songname;
	}


	public String getSongmovie() {
		return songmovie;
	}


	public void setSongmovie(String songmovie) {
		this.songmovie = songmovie;
	}


	public Float getSonglength() {
		return songlength;
	}


	public void setSonglength(Float songlength) {
		this.songlength = songlength;
	}


	public Set getSingerParent() {
		return SingerParent;
	}


	public void setSingerParent(Set singerParent) {
		SingerParent = singerParent;
	}
	
	
}
