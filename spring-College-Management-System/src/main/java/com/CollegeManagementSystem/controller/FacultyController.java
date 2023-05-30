package com.CollegeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.CollegeManagementSystem.service.FacultyService;
import com.CollegeManagementSystem.entity.Faculty;



@Controller
public class FacultyController {
	
	private FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("/")
	public String HomePage(Model model) {
		model.addAttribute("faculties",facultyService.getAllFaculties());
		return "collegeHomePage";
	}
	
	@GetMapping("/faculties")
	public String listFaculties(Model model) {
		model.addAttribute("faculties", facultyService.getAllFaculties());
		return "faculties";
	}
	
	
	//for create form and paste it on front page
	@GetMapping("faculties/new")
	public String createStudentForm(Model model) {
		Faculty faculty = new Faculty();
		model.addAttribute("faculty", faculty);
		return"create_faculty";
	}
	@PostMapping("/faculties")
	public String saveFaculty(@ModelAttribute("faculty")Faculty faculty) {
		facultyService.saveFaculty(faculty);
		return"redirect:/faculties";
	}
	
	
	//for update or edit page
	
	@GetMapping("/faculties/edit/{id}")
	public String editFacultyForm(@PathVariable Long id,Model model) {
		model.addAttribute("faculty", facultyService.getFacultyById(id));
		return "edit_faculty";
	}
	
	@PostMapping("/faculties/{id}")
	public String updateFaculty(@PathVariable Long id,
			@ModelAttribute("faculty") Faculty faculty,
			Model model) {
		
		// get student from database by id
		Faculty existingFaculty = facultyService.getFacultyById(id);
		existingFaculty.setId(id);
		existingFaculty.setFirstName(faculty.getFirstName());
		existingFaculty.setLastName(faculty.getLastName());
		existingFaculty.setEmail(faculty.getEmail());
		existingFaculty.setDetails(faculty.getDetails());
		
		// save updated student object
		facultyService.saveFaculty(existingFaculty);
		return "redirect:/faculties";		
	}
	
	@GetMapping("/faculties/{id}")
	public String deleteFaculty(@PathVariable Long id) {
		facultyService.deleteFacultyById(id);
		return "redirect:/faculties";
	}
	
	
	
	
	
	
	
	
	

}
