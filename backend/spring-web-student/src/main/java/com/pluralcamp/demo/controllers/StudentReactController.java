package com.pluralcamp.demo.controllers;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.client.WebClient;

import com.pluralcamp.demo.SpringBootWebApplication;
import com.pluralcamp.demo.model.Student;

import reactor.core.publisher.Mono;

//https://www.baeldung.com/spring-webclient-resttemplate

//@Controller
public class StudentReactController {

	private WebClient webClient =
			WebClient.create(SpringBootWebApplication.API_URL);

	@GetMapping("/students")
	public String getStudents(Model model){
		Mono<List<Student>> response =  this.webClient.get()
		.uri("/student/students")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve()
		.bodyToMono(new ParameterizedTypeReference<List<Student>>() {});
		List<Student> studentList = response.block();
		model.addAttribute("students", studentList);
		return "students";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new Student());
		return "addStudent";
	}
	
	//To add a new Student
	@PostMapping("/addStudent")
	public String addStudent(Student student, Model model) {
		Mono<Student> response = this.webClient.post()
				.uri("/student/students")
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(student)
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<Student>() {});
		Student createdStudent = response.block();
		model.addAttribute("createdStudent", createdStudent);		
		return this.getStudents(model);
		//return "students";
	}
	
}
