package com.sabanciuniv.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.Student;


public interface StudentRepo extends MongoRepository<Student, String>{
	


	public List<Student> findByUsername(String username);
}
