package com.pluralcamp.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralcamp.demo.exceptions.ResourceNotFoundException;
import com.pluralcamp.demo.model.Student;
import com.pluralcamp.demo.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;	
	
	/*
	 * Get List of Students from MySql
	 */
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public List<Student> getStudentsByName(String name){
		return studentRepository.findByName(name);
	}
	
	public Student getStudentById(int id) throws ResourceNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if(!student.isPresent()) {
			throw new ResourceNotFoundException("Recurso no encontrado!");
		}
		return student.get();
	}
	
	public List<Student> getStudentsByNameAndSurname(String name, String surname){
		return studentRepository.findByNameAndSurname(name, surname);
	}
	
	public List<Student> getStudentsByAge(int age){
		return studentRepository.findByAge(age);
	}
	
	/**
	 * @param student
	 * @return l'objecte Student guardat a la base de dades
	 */
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) 
			throws ResourceNotFoundException{
		Optional<Student> oldStudent = 
				studentRepository.findById(student.getIdstudent());
		if(!oldStudent.isPresent()) {
			throw new ResourceNotFoundException("Recurso no encontrado!");
		} else {
			Student studentToUpdate = oldStudent.get();
			studentToUpdate.setName(student.getName());
			studentToUpdate.setSurname(student.getSurname());
			studentToUpdate.setAge(student.getAge());
			Student updatedStudent = studentRepository.save(studentToUpdate);
			return updatedStudent;
		}
	}
	
	
}
