package com.irken.suzu.sherlock.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irken.suzu.sherlock.bean.DiaryBean;
import com.irken.suzu.sherlock.entity.DiaryEntity;
import com.irken.suzu.sherlock.repository.DiaryRepository;

@RestController
@RequestMapping(path="/diary")
public class DiaryController {
	
	@Autowired
	private DiaryRepository diaryRep;

	@GetMapping(path="/all")
	public ResponseEntity<List<DiaryBean>> getAll(){
		List<DiaryEntity> all = diaryRep.findAll();
		List<DiaryBean> response = new ArrayList<DiaryBean>();
		all.stream().forEach((entity) -> {
			DiaryBean diary = new DiaryBean();
			diary.setIdDiary((int) entity.getIdDiary());
			diary.setColor(entity.getColor());
			diary.setEnd(entity.getEnd());
			diary.setName(entity.getName());
			diary.setStart(entity.getStart());
			response.add(diary);
		});
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<DiaryBean> getDiary(@PathVariable(required=true, name="id") int id){
		DiaryBean diary = new DiaryBean();
		DiaryEntity ent = diaryRep.getReferenceById(id);
		if(ent == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		diary.setColor(ent.getColor());
		diary.setEnd(ent.getEnd());
		diary.setIdDiary(ent.getIdDiary());
		diary.setName(ent.getName());
		diary.setStart(ent.getStart());
		return new ResponseEntity<>(diary, HttpStatus.OK);
	}
	
	@PostMapping(
			path="/save",
			produces="application/json")
	public ResponseEntity<DiaryBean> saveDiary(
			@RequestParam String start, 
			@RequestParam String name,
			@RequestParam String end,
			@RequestParam String color){
		
		if(start == null || name == null || end == null || color == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		DiaryBean diary = new DiaryBean();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
			formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			diary.setStart(formatter.parse(start));
			diary.setName(name);
			diary.setEnd((Date) formatter.parse(end));
			diary.setColor(color);
			DiaryEntity ent = new DiaryEntity();
			ent.setStart(diary.getStart());
			ent.setName(diary.getName());
			ent.setEnd(diary.getEnd());
			ent.setColor(diary.getColor());
			ent = diaryRep.save(ent);
			diary.setIdDiary((int) ent.getIdDiary());
			diary.setStart(formatter.parse(
					(new StringBuilder(100))
					.append(diary.getStart().getHours())
					.append(":")
					.append(diary.getStart().getMinutes())
					.append(":00").toString()
					));
			diary.setEnd(formatter.parse(
					(new StringBuilder(100))
					.append(diary.getStart().getHours())
					.append(":")
					.append(diary.getStart().getMinutes())
					.append(":00").toString()
					));
		} catch(ParseException ex) {
			ex.printStackTrace();
			System.out.println(ex.toString());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(diary, HttpStatus.CREATED);
	}
	
	@PutMapping(
			path="/update",
			produces="application/json")
	public ResponseEntity<DiaryBean> updateDiary(
			@RequestParam int id, 
			@RequestParam String start, 
			@RequestParam String name,
			@RequestParam String end,
			@RequestParam String color) {
		DiaryBean diary = new DiaryBean();
		if(start == null || name == null || end == null || color == null) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss", Locale.ENGLISH);
			formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
			diary.setStart(formatter.parse(start));
			diary.setName(name);
			diary.setEnd((Date) formatter.parse(end));
			diary.setColor(color);
			DiaryEntity ent = new DiaryEntity();
			ent.setIdDiary(id);
			ent.setStart(diary.getStart());
			ent.setName(diary.getName());
			ent.setEnd(diary.getEnd());
			ent.setColor(diary.getColor());
			ent = diaryRep.save(ent);
			diary.setIdDiary((int) ent.getIdDiary());
			diary.setStart(formatter.parse(
					(new StringBuilder(100))
					.append(diary.getStart().getHours())
					.append(":")
					.append(diary.getStart().getMinutes())
					.append(":00").toString()
					));
			diary.setEnd(formatter.parse(
					(new StringBuilder(100))
					.append(diary.getStart().getHours())
					.append(":")
					.append(diary.getStart().getMinutes())
					.append(":00").toString()
					));
		} catch(ParseException ex) {
			ex.printStackTrace();
			System.out.println(ex.toString());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(diary, HttpStatus.OK);
	}
	
	@DeleteMapping(
			path="/delete/{id}",
			produces="application/json")
	public ResponseEntity<String> deleteEntity(@PathVariable(required=false,name="id") int id){
		diaryRep.deleteById(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);
	}
	
	@DeleteMapping(
			path="delete/all",
			produces="application/json")
	public ResponseEntity<String> deleteAll(){
		diaryRep.deleteAll();
		return new ResponseEntity<>("All deleted", HttpStatus.OK);
	}
}
