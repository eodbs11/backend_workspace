package com.kh.example.practice2.model;

public class music {
	private String musicname;
	private String singername;

	public music() {
	}

	public music(String musicname, String singername) {
		this.musicname = musicname;
		this.singername = singername;
	}

	public String getMusicname() {
		return musicname;
	}

	public void setMusicname(String musicname) {
		this.musicname = musicname;
	}

	public String getSingername() {
		return singername;
	}

	public void setSingername(String singername) {
		this.singername = singername;
	}

	@Override
	public String toString() {
		return "music [musicname=" + musicname + ", singername=" + singername + "]";
	}

}
