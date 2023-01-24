package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanket.exception.StudentException;
import com.sanket.model.Student;
import com.sanket.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/registerStudent")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) throws StudentException{
		
		
		if(student != null) {
			
			Student registerStudent = studentServiceImpl.registerStudent(student);
			
			
			return new ResponseEntity<Student>(registerStudent, HttpStatus.CREATED);
			
		}else {
			
			throw new StudentException("Please enter valid details");
			
		}
		
		
	}

}
