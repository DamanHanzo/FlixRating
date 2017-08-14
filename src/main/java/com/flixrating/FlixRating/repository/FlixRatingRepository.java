package com.flixrating.FlixRating.repository;


import com.flixrating.FlixRating.model.FlixRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlixRatingRepository extends JpaRepository<FlixRating, Long> {
}
