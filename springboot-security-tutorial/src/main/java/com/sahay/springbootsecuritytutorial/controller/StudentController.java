package com.sahay.springbootsecuritytutorial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahay.springbootsecuritytutorial.model.Student;

@RestController
public class StudentController {
	private List<Student> students=new ArrayList<>(); 
	{
		students.add(new Student(1, "Katrina", "Kaif"));
		students.add(new Student(2, "Sunny", "Leone"));
	}
	
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping
	public List<Student> students(){
		
		
		return students;
	}
	@PreAuthorize("hasRole('ADMIN')") //now only admin can use this method
	@PostMapping
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		students.add(student);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
}
