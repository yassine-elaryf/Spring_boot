package com.example.demo.dao;

import java.util.List;





public interface StudentDAO<T> {
	List<T>getAllStudents();
	public T getStudentById(Long id);
	 public T saveStudent(T stu);
	 public T update(T student);
	 public void delete(Long id);
}
