package com.sabanciuniv.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Course {
	
	@Id
	String id;
	
	String name;
	String about;
	String info;
	String instructor;
	String term;
	int capacity;
	int attendnum;
	

	List<Comment> comments;
	
	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String name, String about, String info, String instructor, String term, int capacity,
			int attendnum,List<Comment>  comments) {
		super();
		this.name = name;
		this.about = about;
		this.info = info;
		this.instructor = instructor;
		this.term = term;
		this.capacity = capacity;
		this.attendnum = attendnum;
		this.comments = comments;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAttendnum() {
		return attendnum;
	}

	public void setAttendnum(int attendnum) {
		this.attendnum = attendnum;
	}

	public List<Comment>  getComments() {
		return comments;
	}

	public void setComments(List<Comment>  comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", about=" + about + ", info=" + info
				+ ", instructor=" + instructor + ", term=" + term + ", capacity=" + capacity + ", attendnum="
				+ attendnum + ", comments=" + comments + "]";
	}


	
	
	
	
	

}
