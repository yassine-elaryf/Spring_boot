package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;

@Controller
public class StudentControllerRepo {

	@Autowired
	StudentRepository studentRepository;
	@GetMapping(value = "/indexR")
	public  String homePage() { 
		return "indexR";
	}
	@GetMapping(value="/showStudentR")
	public String showStudentInfo(Model model) {
	List<StudentEntity> students = studentRepository.findAll();
		
		for(StudentEntity stu:students) {
			System.out.println(stu);
		}
		model.addAttribute("students",students);
		return "student-listR";
	}
	@GetMapping(value = "/addStudentR")
	public String addStudent(Model model) {
		 StudentDTO studentDTO = new StudentDTO();
		 System.out.println(studentDTO);
		model.addAttribute("student",studentDTO);
		return "add-studentR";
	}
	@PostMapping(value = "/saveStudentR")
	public String addStudent(StudentEntity student) {
		System.out.println(student);
studentRepository.save(student);
		return "redirect:/showStudentR";
	}
	@GetMapping(value = "/editR" )
	public String editStudent(@RequestParam Long id,Model model) {
	
	   System.out.println( studentRepository.findById(id).get());
		model.addAttribute("student",studentRepository.findById(id).get());
		return "edit-studentR";
	}
	@PostMapping(value = "/updateR" )
	public String updateStudent(StudentEntity student) {
		studentRepository.save(student);
		return "redirect:/showStudentR";
	}
	@GetMapping(value = "/deleteR/{id}")
	public String deleteStudent(@PathVariable Long id) {
		  studentRepository.findById(id);
		  studentRepository.deleteById(id);
		return "redirect:/showStudentR";
	}
}

