package com.flixrating.FlixRating.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    private int id;
    private String username;
    private String message;
    private FlixRating flixRating;

    public Comments() { }

    public Comments(int id, String username, String message){
        this.id = id;
        this.username = username;
        this.message = message;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ManyToOne
    @JoinColumn(name = "flix_id")
    public FlixRating getFlixRating(){
        return flixRating;
    }

    public void setFlixRating(FlixRating flixRating) {
        this.flixRating = flixRating;
    }
}
