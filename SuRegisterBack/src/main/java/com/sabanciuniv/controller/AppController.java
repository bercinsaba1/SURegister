package com.sabanciuniv.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sabanciuniv.model.Course;
import com.sabanciuniv.model.Student;
import com.sabanciuniv.repo.CourseRepo;
import com.sabanciuniv.repo.StudentRepo;

@RequestMapping("/suregister")
@RestController
public class AppController {
	
	
	
	@Autowired CourseRepo courseRepo;
	@Autowired StudentRepo studentRepo;
	
	@GetMapping("/getallc")
	public List<Course> GetAllCourses (){
		
		return courseRepo.findAll();
	}
	
	@GetMapping("/searchbynamec/{name}")
	public List<Course> SearchCourseName (@PathVariable String name){
		
		return courseRepo.findByName(name);
	}
	
	@GetMapping("/searchbycapacityc/{capacity}")
	public List<Course> SearchCourseCapacity (@PathVariable int capacity){
		
		return courseRepo.findByCapacity(capacity);
	}
	
	@PostMapping("/assigncourse")
	public String AssignCourse(@RequestBody Course newcourse) {
		
		courseRepo.insert(newcourse);
		return "Course is saved successfully";
		
	}
	
	@GetMapping("/getalls")
	public List<Student> GetAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/searchbynames/{username}")
	public List<Student> SearchStudentName(@PathVariable String username){
		return studentRepo.findByUsername(username);
	}
	
	@PostMapping("/assignstudent")
	public String AssignStudent(@RequestBody Student newstudent){
		
		studentRepo.insert(newstudent);
		return "Student is saved successfully";
	}
	
	
	
	
	
	

}
