package com.flixrating.FlixRating.controller;

import com.flixrating.FlixRating.model.Comments;
import com.flixrating.FlixRating.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@Autowired
	private CommentsRepository commentsRepository;

	@RequestMapping("")
	public String home() {
		return "redirect:index.html";
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public Comments create() {
		Comments comment = new Comments();
		comment.setMessage("Hello");
		comment.setUsername("USER");

		return commentsRepository.saveAndFlush(comment);
	}

}
