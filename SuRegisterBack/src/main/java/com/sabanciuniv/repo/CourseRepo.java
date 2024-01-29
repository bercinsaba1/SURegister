package com.sabanciuniv.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Course;

public interface CourseRepo extends MongoRepository<Course, String>{
	

	public List<Course> findByName(String name);
	public List<Course> findByCapacity(int capacity);

	
}
