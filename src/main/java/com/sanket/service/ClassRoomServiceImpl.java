package com.sanket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanket.model.ClassRoom;
import com.sanket.repository.ClassRoomDao;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{
	
	
	@Autowired
	ClassRoomDao classRoomDao;

	@Override
	public ClassRoom createClassRoom(ClassRoom classRoom) throws ClassCastException {
		
		return classRoomDao.save(classRoom);
		
	}

}
