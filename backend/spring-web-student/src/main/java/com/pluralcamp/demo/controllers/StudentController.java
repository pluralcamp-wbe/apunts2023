package com.pluralcamp.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.pluralcamp.demo.model.Student;

@Controller
public class StudentController {

	//inject via application.properties
	@Value("${api.url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	//***************** READ **************************
	
	@GetMapping("/students")
	public String getStudents(Model model) {

		String url = this.apiUrl + "/student/students";

		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(url, Student[].class);

		Student[] studentsArray = response.getBody();

		List<Student> studentsList = Arrays.asList(studentsArray);

		model.addAttribute("students", studentsList);

		return "students";
	}
	
	//*********************** ADD **************************
	
	@GetMapping("/addStudent")
	public ModelAndView addStudentForm() {
		ModelAndView mav = new ModelAndView("addStudent");
		Student student = new Student();
		mav.addObject("student",student);
		return mav;
	}	
	
//	@PostMapping("/addStudent")
//	public String saveStudent(Model model, @ModelAttribute Student student) {
//		String url = this.apiUrl + "/student/students";
//		ResponseEntity<Student> createdStudentResponse = 
//				restTemplate.postForEntity(url, student, Student.class);
//		Student createdStudent = createdStudentResponse.getBody();
//		model.addAttribute("createdStudent", createdStudent);
//		return getStudents(model);
//	}
	
	@PostMapping("/addStudent")
	public String saveStudent(@ModelAttribute Student student) {
		String url = this.apiUrl + "/student/students";
		restTemplate.postForEntity(url, student, String.class);
		return "redirect:/students";
	}
	
//	@PostMapping("/addStudent")
//	public String saveStudent(Model model, @ModelAttribute Student student) {
//		String url = this.apiUrl + "/student/students";
//		ResponseEntity<String> rawResponse = 
//				restTemplate.postForEntity(url, student, String.class);
//		model.addAttribute("rawResponse", rawResponse);
//		return getStudents(model);
//	}
	
	
	//***************** DELETE ***********************
	
	@GetMapping("/studentsDelete")
	public String getStudentsDelete(Model model) {

		String url = this.apiUrl + "/student/students";

		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(url, Student[].class);

		Student[] studentsArray = response.getBody();

		List<Student> studentsList = Arrays.asList(studentsArray);

		model.addAttribute("students", studentsList);

		return "studentsDelete";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		
	   String url = this.apiUrl + "/student/delete/id/" + id;
	   
	   restTemplate.delete(url);
	   
	   return "redirect:/students";   	   	  
	}
	
	
	//***************** UPDATE ***********************
	
	@GetMapping("/studentsUpdate")
	public String getStudentsUpdate(Model model) {

		String url = this.apiUrl + "/student/students";

		ResponseEntity<Student[]> response = 
				restTemplate.getForEntity(url, Student[].class);

		Student[] studentsArray = response.getBody();

		List<Student> studentsList = Arrays.asList(studentsArray);

		model.addAttribute("students", studentsList);

		return "studentsUpdate";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable Integer id, Model model) {
		
		String url = this.apiUrl + "/student/students/id/" + id;
		
		ResponseEntity<Student> studentByIdResponse = 
				restTemplate.getForEntity(url,  Student.class);
		Student studentToUpdate = (Student)studentByIdResponse.getBody();
		model.addAttribute("student", studentToUpdate);
		return addStudentMvc(model);
//	   return "redirect:/addStudentMvc";   	   	  
	}
	
	@GetMapping("/updateStudent")
	public String addStudentMvc(Model model) {				
		return "updateStudent";
	}	
	

}
