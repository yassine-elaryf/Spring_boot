package com.example.demo.models;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class User {
	private String username;
	private String password;
	private String fullname;
	private String enabled; 
}
