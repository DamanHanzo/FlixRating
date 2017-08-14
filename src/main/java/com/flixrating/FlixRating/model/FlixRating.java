package com.flixrating.FlixRating.model;

import javax.persistence.*;
import java.util.Set;
//import java.io.Serializable;

@Entity
@Table(name="flix_rating")
public class FlixRating {

//	private static final long serialVersionUID = -7049957706738879274L;
	private Set<Comments> comments;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name="flixratings_id_seq", allocationSize = 1)
//	@Column(name = "ID")
	Long id;
	String name;
	String description;
	Double avgRating;
	String genre;

	public FlixRating() { }

	public FlixRating(Long id, String name, String description, Double avgRating, String genre) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.avgRating = avgRating;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@OneToMany(mappedBy = "FlixRating", cascade = CascadeType.ALL)
	public Set<Comments> getComments(){
		return comments;
	}

	public void setComments(Set<Comments> comments) {
		this.comments = comments;
	}
}
