package com.sanket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.exception.ClassRoomException;
import com.sanket.exception.StudentException;
import com.sanket.model.ClassRoom;
import com.sanket.model.Student;
import com.sanket.repository.ClassRoomDao;
import com.sanket.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	ClassRoomDao classRoomDao;

	@Override
	public Student registerStudent(Student student, Integer classRoom) throws StudentException, ClassRoomException {
		
		if(student != null) {
			
			List<ClassRoom> listOfClassRooms = classRoomDao.findAll();
			
			for(ClassRoom eachClassRooms: listOfClassRooms) {
				
				if(eachClassRooms.getClassRoomStandard() == classRoom) {
					
					student.setClassRoom(eachClassRooms); 
					
					eachClassRooms.getListOfStudents().add(student);
					
					classRoomDao.save(eachClassRooms);
					
					return student;
					
				
			}	
				
		}
			
			throw new ClassRoomException("Class room not found with this number " + classRoom);
				
		}else {
			
			throw new StudentException("Please enter valid student details");
			
		}
	
		
	}
	
	
	
	
}
