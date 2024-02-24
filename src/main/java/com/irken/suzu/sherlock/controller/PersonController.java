package com.irken.suzu.sherlock.controller;

import org.springframework.web.bind.annotation.RestController;

import com.irken.suzu.sherlock.bean.HelloSherlockBean;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// REST API
@RestController
public class PersonController {
	
	// return a hello world string
	@RequestMapping(method = RequestMethod.GET, path = "/hello-sherlock")
	public String helloSherlock() {
		return "Hello Sherlock!";
	}
	
	@GetMapping(path = "/hello-sherlock-bean")
	public HelloSherlockBean helloSherlockBean() {
		return new HelloSherlockBean("Hello Sherlock!");
	}
	
	@GetMapping(path = "/path/{name}")
	public String pathMethod(@PathVariable String name) {
		return String.format("Hello %s !!", name);
	}
}

