package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanket.exception.ClassRoomException;
import com.sanket.exception.StudentException;
import com.sanket.model.Student;
import com.sanket.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/registerStudent/{classRoom}")
	public ResponseEntity<Student> registerStudentToClassRoom(@RequestBody Student student, @PathVariable Integer classRoom) throws StudentException, ClassRoomException{
		
		
		if(student != null) {
			
			Student registerStudent = studentServiceImpl.registerStudent(student, classRoom);
			
			
			return new ResponseEntity<Student>(registerStudent, HttpStatus.CREATED);
			
		}else {
			
			throw new StudentException("Please enter valid details");
			
		}
		
		
	}
	
	@PostMapping("/updateClassRoom/{newclassRoom}")
	public ResponseEntity<String> updateStudentClassRoom(@RequestBody Student student, @PathVariable Integer newclassRoom) throws StudentException, ClassRoomException{
		
		if(student != null) {
			
			String result = studentServiceImpl.updateStudentClassRoom(student, newclassRoom);
			
			
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
			
		}else {
			
			throw new StudentException("Please enter valid details"); 
			 
		}
	}

}
