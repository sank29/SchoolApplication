package com.sanket.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer classRoomStandard;
	
	private String classRoomName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Student> listOfStudents;

}
