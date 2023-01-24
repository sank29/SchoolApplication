package com.sanket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanket.model.ClassRoom;

public interface ClassRoomDao extends JpaRepository<ClassRoom, Integer> {

}
