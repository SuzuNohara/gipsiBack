package com.irken.suzu.sherlock.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "diary")
public class DiaryEntity {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "id")
	private int idDiary;
	
	@Column(name = "start")
	@Temporal(TemporalType.TIME)
	private Date start;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "end")
	@Temporal(TemporalType.TIME)
	private Date end;
	
	@Column(name = "color")
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

	public void setStart(Date start) {
		this.start = start;
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
