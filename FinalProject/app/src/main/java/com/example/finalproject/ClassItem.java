package com.example.finalproject;

import java.io.Serializable;
import java.util.List;

public class ClassItem implements Serializable{
    private int capacity;
    private int attendnum;
    private String info;
    private String title; // refers to name
    private String about;
    private String instructor;
    private List<Comment> comments;

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public ClassItem(){}
    public ClassItem(int capacity,int attendnum, String title, String about, String instructor, String info, List<Comment> comments ) {
        this.attendnum = attendnum ;
        this.title = title;
        this.capacity = capacity;
        this.info = info;
        this.about = about;
        this.instructor = instructor;
        this.comments = comments;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
