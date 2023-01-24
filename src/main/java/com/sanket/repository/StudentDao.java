package com.sanket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{
	
	

}
