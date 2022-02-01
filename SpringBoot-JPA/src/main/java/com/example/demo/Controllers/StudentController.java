package com.example.demo.Controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
@Transactional
@Controller
public class StudentController {

@Autowired
private StudentDAO<StudentEntity> studentDAO;
	@GetMapping(value = "/")
	public  String homePage() { 
		return "index";
	}
	@GetMapping(value="/showStudent")
	public String showStudentInfo(Model model) {
		
		List<StudentEntity> students = studentDAO.getAllStudents();
		
		for(StudentEntity stu:students) {
			System.out.println(stu);
		}
		model.addAttribute("students",students);
		return "student-list";
		
	}
	@GetMapping(value = "/addStudent")
	public String addStudent(Model model) {
		 StudentDTO studentDTO = new StudentDTO();
		 System.out.println(studentDTO);
		model.addAttribute("student",studentDTO);
		return "add-student";
	}
	@PostMapping(value = "/saveStudent")
	public String addStudent(StudentEntity student) {
		System.out.println(student);
studentDAO.saveStudent(student);
		return "redirect:/showStudent";
	}
	@GetMapping(value = "/edit" )
	public String editStudent(@RequestParam Long id,Model model) {
		StudentEntity student = studentDAO.getStudentById(id);
		model.addAttribute("student",student);
		return "edit-student";
	}
	@PostMapping(value = "/update" )
	public String updateStudent(StudentEntity student) {
		studentDAO.update(student);
		return "redirect:/showStudent";
	}
	@GetMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		 studentDAO.delete(id);
		return "redirect:/showStudent";
	}
}
