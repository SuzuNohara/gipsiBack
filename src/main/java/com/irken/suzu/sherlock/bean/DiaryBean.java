package com.irken.suzu.sherlock.bean;

import java.util.Date;

public class DiaryBean {

	private int idDiary;
	private Date start;
	private String name;
	private Date end;
	private String color;
	
	public int getIdDiary() {
		return idDiary;
	}
	public void setIdDiary(int idDiary) {
		this.idDiary = idDiary;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date stert) {
		this.start = stert;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
