package com.sabanciuniv.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	@Id
	String id;
	
	String username;
	int suid;
	String password;
	int grade;
	
	@DBRef
	List<Course> attended;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String username, int suid, String password, int grade, List<Course>  attended) {
		super();
		this.username = username;
		this.suid = suid;
		this.password = password;
		this.grade = grade;
		this.attended = attended;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSuid() {
		return suid;
	}

	public void setSuid(int suid) {
		this.suid = suid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Course>  getAttended() {
		return attended;
	}

	public void setAttended(List<Course>  attended) {
		this.attended = attended;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", suid=" + suid + ", password=" + password + ", grade="
				+ grade + ", attended=" + attended + "]";
	}

	
	
	

}
