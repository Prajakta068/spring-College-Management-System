package com.CollegeManagementSystem.service;

import java.util.List;
import com.CollegeManagementSystem.entity.Faculty;



public interface FacultyService {
	
	List<Faculty> getAllFaculties();
	 
	Faculty saveFaculty(Faculty faculty);

	Faculty getFacultyById(Long id);
	
	Faculty updateFaculty(Faculty faculty);
	
	void deleteFacultyById(Long id);

	

}
