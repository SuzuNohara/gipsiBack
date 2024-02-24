package com.irken.suzu.sherlock.bean;

public class HelloSherlockBean {
	
	private String message;
	
	public HelloSherlockBean(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloSherlockBean [message=" + message + "]";
	}
}
