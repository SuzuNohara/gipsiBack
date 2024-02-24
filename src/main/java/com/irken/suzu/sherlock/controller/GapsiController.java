package com.irken.suzu.sherlock.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path="/gapsi")
public class GapsiController {
	
	@CrossOrigin
	@GetMapping(path="/message")
	public ResponseEntity<String> getMessage(){
		int number = 0;
		return new ResponseEntity<>("Bienvenido candidato " + number, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(path="/version")
	public ResponseEntity<String> getVersion(){
		String version = "2.4.31_u15";
		return new ResponseEntity<>(version, HttpStatus.OK);
	}

}
