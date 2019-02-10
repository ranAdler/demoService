package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
	
	private String name;
	private int id;
	
	public User() {
	
	}
	
	public User(String name, int id) {
		this.name = name;
		this.id = id;
	}
}
