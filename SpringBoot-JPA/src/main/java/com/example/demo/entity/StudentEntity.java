package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "student")
@Table(name ="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentEntity  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "student_id", length = 30)
private String student_id;
@Column(name = "NAME", length = 30)
private String name;
@Column(name = "city", length = 60)
private String city; 
private int age;
}
