package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class StudentDTO {
	private int student_id = 1000;
	private String name = "yassine";
	private String city="slsabil";
	private int age = 37;
}
