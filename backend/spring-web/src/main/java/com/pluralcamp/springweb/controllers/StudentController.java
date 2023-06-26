package com.pluralcamp.springweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.pluralcamp.springweb.model.Student;

@Controller
public class StudentController {

	@Autowired
	private RestTemplate restTemplate;
	
	//Injecteu el valor de la URL de l'API Rest
	@Value("${apirest.url}")
	private String apiUrl;
	
	@GetMapping("/students")
	public String getStudents(Model model) {

		String apiUrl = this.apiUrl + "/student/students";

		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(apiUrl, Student[].class);

		Student[] studentsArray = response.getBody();

		List<Student> studentsList = Arrays.asList(studentsArray);

		model.addAttribute("students", studentsList);

		return "students";
	}
	
	@GetMapping("/addStudent")
	public ModelAndView addStudentForm() {
		ModelAndView mav = new ModelAndView("addStudent");
		Student student = new Student();
		mav.addObject("student",student);
		return mav;
	}	
	
	
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student) {
		String apiUrl = this.apiUrl + "/student/students";
		restTemplate.postForEntity(apiUrl, student, String.class);
		return "redirect:/studentList";
	}	
	
}
