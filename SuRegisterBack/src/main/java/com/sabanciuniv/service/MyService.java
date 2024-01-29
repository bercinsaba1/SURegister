package com.sabanciuniv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabanciuniv.model.Comment;
import com.sabanciuniv.model.Course;
import com.sabanciuniv.model.Student;
import com.sabanciuniv.repo.CourseRepo;
import com.sabanciuniv.repo.StudentRepo;

import jakarta.annotation.PostConstruct;

@Service
public class MyService {
	
	@Autowired StudentRepo studentRepo;
	@Autowired CourseRepo courseRepo;
	
	
	
	@PostConstruct
	public void init() {
		
		if(courseRepo.count() == 0) {
			
			//Save Courses
			Course c1 = new Course("CS303", "This is well designed course", "Credit: 4", "Ayhan Bozkurt", "Fall", 200, 150, null);
			Course c2 = new Course("CS204", "This is must course", "Credit: 3", "Gülsen Demiroz", "Spring", 300, 120, null);
			Course c3 = new Course("CS412", "This is required course", "Credit: 3", "Berrin Yanıkoğlu", "Fall", 400, 200, null);
			Course c4 = new Course("CS300", "This is hard course", "Credit: 3", "Ayhan Bozkurt", "Spring", 100, 40, null);
			Course c5 = new Course("IF100", "This is beginner course", "Credit: 3", "Inanc Arın", "Fall", 160, 50, null);
			
			List<Course> courses = new ArrayList<>();
			courses.add(c1);
			courses.add(c2);
			courses.add(c3);
			courses.add(c4);
			courses.add(c5);
			
			courseRepo.saveAll(courses);
			
			Student s1 = new Student("colakhalil", 28870, "1234", 2, null);
			Student s2 = new Student("yeren", 29812, "1234", 2, null);
			Student s3 = new Student("bercin", 12341, "4321", 3, null);
			Student s4 = new Student("femre", 1291, "1234", 2, null);
			Student s5 = new Student("umitcolak", 1242, "1234", 3, null);
			
			//Save Students
			List<Student> students = new ArrayList<>();
			
			students.add(s1);
			students.add(s2);
			students.add(s3);
			students.add(s4);
			students.add(s5);
			
			studentRepo.saveAll(students);
			
			
			//Students will add Courses
			
			List<Course> courses1 = new ArrayList<>();
			courses1.add(c1);
			courses1.add(c3);
			courses1.add(c5);
			List<Course> courses2 = new ArrayList<>();
			courses2.add(c2);
			courses2.add(c4);
			courses2.add(c1);
			List<Course> courses3 = new ArrayList<>();
			courses3.add(c4);
			courses3.add(c3);
			courses3.add(c2);
			
			s1.setAttended(courses);
			s2.setAttended(courses1);
			s3.setAttended(courses3);
			s4.setAttended(courses2);
			s5.setAttended(courses);
			
			
			studentRepo.saveAll(students);
			
			
			
			//Students will make commands on courses
			
			Comment cmd1 = new Comment("Bu dersi ben aldim siz almayin", s1.getUsername());
			Comment cmd2 = new Comment("Bence cok güzel ders kesin alin", s2.getUsername());
			
			List<Comment> comments = new ArrayList<>();
			comments.add(cmd1);
			comments.add(cmd2);
		
			c1.setComments(comments);
			
			Comment cmd3 = new Comment("Kamer hocadan almayin", s3.getUsername());
			Comment cmd4 = new Comment("Albert Hocadan alin", s4.getUsername());
			
			List<Comment> comments1 = new ArrayList<>();
			comments1.add(cmd3);
			comments1.add(cmd4);
		
			c2.setComments(comments1);
			
			
			Comment cmd5 = new Comment("Gülsen hoca cok tatli", s5.getUsername());
			Comment cmd6 = new Comment("Odevleri cok zor", s3.getUsername());
			
			List<Comment> comments2 = new ArrayList<>();
			comments2.add(cmd5);
			comments2.add(cmd6);
		
			c3.setComments(comments2);
			
			Comment cmd7 = new Comment("Kolay ders easy A", s2.getUsername());
			Comment cmd8 = new Comment("Dersi ucuncuye aliyorum sakin almayin ytd", s4.getUsername());
			
			List<Comment> comments3 = new ArrayList<>();
			comments3.add(cmd7);
			comments3.add(cmd8);
		
			c4.setComments(comments3);
			
			Comment cmd9 = new Comment("Ayhan Hoca mükemmel", s1.getUsername());
			Comment cmd10 = new Comment("EE okumayacaksaniz almayiniz", s5.getUsername());
			
			List<Comment> comments4 = new ArrayList<>();
			comments4.add(cmd9);
			comments4.add(cmd10);
		
			c5.setComments(comments4);
			
			courseRepo.saveAll(courses);
			

		}

		
		
	}

}
