package com.sanket.service;

import com.sanket.exception.ClassRoomException;
import com.sanket.exception.StudentException;
import com.sanket.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student, Integer classRoom) throws StudentException, ClassRoomException;
	
	public Student updateStudentClassRoom(Student student, Integer newClassRoom) throws StudentException, ClassRoomException;;

}
