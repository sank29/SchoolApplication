package com.sanket.service;

import com.sanket.exception.StudentException;
import com.sanket.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student) throws StudentException;

}
