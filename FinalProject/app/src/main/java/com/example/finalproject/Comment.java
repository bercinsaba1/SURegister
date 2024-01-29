package com.example.finalproject;

import java.io.Serializable;

public class Comment  implements Serializable {

    String comment;

    String commander;

    public Comment() {
        // TODO Auto-generated constructor stub
    }

    public Comment(String comment, String commander) {
        super();
        this.comment = comment;
        this.commander = commander;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommander() {
        return commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
    }

    @Override
    public String toString() {
        return (commander + ": " + comment);
    }


}