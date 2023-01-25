package com.sanket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.exception.StudentException;
import com.sanket.model.ClassRoom;
import com.sanket.model.Student;
import com.sanket.repository.ClassRoomDao;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{
	
	
	@Autowired
	ClassRoomDao classRoomDao;

	@Override
	public ClassRoom createClassRoom(ClassRoom classRoom) throws ClassCastException {
		
		return classRoomDao.save(classRoom);
		
	}

	@Override
	public List<Student> getListOfStudent(Integer classRoom) throws ClassCastException, StudentException {
		
		List<ClassRoom> listOfClassRoom = classRoomDao.findAll();
		
		System.out.println(listOfClassRoom);
		
		Boolean flag = false;
		
		ClassRoom requiredClassRoom = null;
		
		
		for(ClassRoom eachClassRoom : listOfClassRoom) {
			
			if(eachClassRoom.getClassRoomStandard() == classRoom) {
				
				requiredClassRoom = eachClassRoom;
				flag = true;
				
			}
		}
		
		if(flag == true) {
			
			List<Student> listOfStudent = requiredClassRoom.getListOfStudents();
			
			if(!listOfStudent.isEmpty()) {
				
				return listOfStudent;
				
			}else {
				
				throw new StudentException("No student found in this class room " + classRoom);
			}
			
			
			
		}else {
			
			throw new ClassCastException("Please enter valid class room number " + classRoom);
		}
		
	}

}
