package com.sanket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sanket.model.ClassRoom;
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
}
