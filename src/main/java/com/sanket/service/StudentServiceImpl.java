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

	@Override
	public String updateStudentClassRoom(Student student, Integer newClassRoom)
			throws StudentException, ClassRoomException {
		
		System.out.println(student);
		
		ClassRoom newClassRoomStudentToBeAdded = null;
		
		if(student.getClassRoom().getClassRoomStandard() != newClassRoom) {
			
			List<ClassRoom> listOfClassRooms = classRoomDao.findAll();
			
			boolean flag = false;
			
			
			for(ClassRoom eachClassRoom : listOfClassRooms) {
				
				if(eachClassRoom.getClassRoomStandard() == newClassRoom) {
					
					newClassRoomStudentToBeAdded = eachClassRoom;
							
					flag = true;
					
					break;
					
				}
			}
			
			if(flag == true) {
				
				ClassRoom presentClassRoom = student.getClassRoom();
				
				List<Student> listOfStudent = presentClassRoom.getListOfStudents();
				
				int count = 0;
				
				for(Student eachStudent: listOfStudent) {
					
					if(eachStudent.getStudentRoll() == student.getStudentRoll()) {
						
						break;
					}
					count++;
				}
				
				listOfStudent.remove(count);
				
				presentClassRoom.setListOfStudents(listOfStudent);
				
				classRoomDao.save(presentClassRoom);
				
				newClassRoomStudentToBeAdded.getListOfStudents().add(student);
				
				classRoomDao.save(newClassRoomStudentToBeAdded);
				
				return "Added";
				
			}else {
				
				throw new ClassRoomException("No classroom find with this number " + newClassRoom);
			}
			
		}else {
			
			throw new StudentException("Student already present in that class " + newClassRoom);
		}
		
		
		
	}
	
	
	
	
}
