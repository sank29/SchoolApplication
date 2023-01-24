package com.sanket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.exception.StudentException;
import com.sanket.model.Student;
import com.sanket.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student registerStudent(Student student) throws StudentException {
		
		if(student != null) {
			
			return studentDao.save(student);
		}
		
		
		throw new StudentException("Please enter valid student details");
		
	}

}
