package com.irken.suzu.sherlock.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.irken.suzu.sherlock.bean.NoteBean;

@RestController
@RequestMapping(path="/note")
public class NoteController {
	
	@GetMapping(path="/")
	public ResponseEntity<List<NoteBean>> getAllNotes(){
		List<NoteBean> notes = new ArrayList<NoteBean>();
		return (ResponseEntity<List<NoteBean>>) ResponseEntity.ok();
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<NoteBean> getNoteById(@PathVariable int id) {
//		return ResponseEntity.created("/note").build();
		return null;
	}
	
	@PostMapping(path="/")
	public ResponseEntity<NoteBean> postNoteBean() {
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/")
				.buildAndExpand(0)
				.toUri();
		return ResponseEntity.created(location).build();
	}
}

/*
 * public User findOne(int id) {
	Predicate<? super User> predicate = user -> user.getId().equals(id); 
	return users.stream().filter(predicate).findFirst().get();
}*/