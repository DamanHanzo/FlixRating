package com.flixrating.FlixRating.repository;

import com.flixrating.FlixRating.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

}
