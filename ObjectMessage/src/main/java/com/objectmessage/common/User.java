package com.objectmessage.common;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private int id;
	private String name;
	private String state;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [Name=" + name + ", Id=" + id + ", State=" + state + "]";
	}
	
	

}
