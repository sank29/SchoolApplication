package com.sanket.service;

import java.util.List;

import com.sanket.exception.StudentException;
import com.sanket.model.ClassRoom;
import com.sanket.model.Student;

public interface ClassRoomService {
	
	public ClassRoom createClassRoom(ClassRoom classRoom) throws ClassCastException;
	
	public List<Student> getListOfStudent(Integer classRoom) throws ClassCastException, StudentException;

}
