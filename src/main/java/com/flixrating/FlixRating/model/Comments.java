package com.flixrating.FlixRating.model;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String message;
    @ManyToOne
    @JoinColumn(name = "flix_id")
    private FlixRating flixRating;

    public Comments() { }

    public Comments(Long id, String username, String message){
        this.id = id;
        this.username = username;
        this.message = message;
    }


    public Long getId(){
        return id;
    }

    public void setId(Long id) {
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


    public FlixRating getFlixRating(){
        return flixRating;
    }

    public void setFlixRating(FlixRating flixRating) {
        this.flixRating = flixRating;
    }
}
