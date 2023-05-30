package com.CollegeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CollegeManagementSystem.entity.Faculty;

//we dont add@repository

//because jparepository interface has a default implementation class that is 
//simplejpaRepository of class of repository it is already in that 

//<1st is jpa entity, 2nd type of primary key>

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	
	

}
