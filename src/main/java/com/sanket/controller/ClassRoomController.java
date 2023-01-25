package com.sanket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanket.exception.StudentException;
import com.sanket.model.ClassRoom;
import com.sanket.model.Student;
import com.sanket.service.ClassRoomService;

@Controller
public class ClassRoomController {
	
	@Autowired
	ClassRoomService classRoomService;
	
	
	@PostMapping("/registerClassRoom")
	public ResponseEntity<ClassRoom> createClassRoom(@RequestBody ClassRoom classRoom) {
		
		
		if(classRoom != null) {
			
			
			ClassRoom createdClassRoom = classRoomService.createClassRoom(classRoom);
			
			return new ResponseEntity<ClassRoom>(createdClassRoom, HttpStatus.CREATED);
			
		}else {
			
			
			throw new ClassCastException("Please enter valid details");
			
		}
	}
	
	@GetMapping("/getStudentList/{classRoom}")
	public ResponseEntity<List<Student>> getListOfStudentInClassRoom(@PathVariable Integer classRoom) throws ClassCastException, StudentException{
		
		if(classRoom != null) {
			
			List<Student> listOfStudent = classRoomService.getListOfStudent(classRoom);
			
			return new ResponseEntity<List<Student>>(listOfStudent, HttpStatus.ACCEPTED);
			
		}else {
			
			throw new ClassCastException("Please enter valid class room number " + classRoom);
		}
		
	}
}
