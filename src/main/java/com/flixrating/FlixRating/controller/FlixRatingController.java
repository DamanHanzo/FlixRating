package com.flixrating.FlixRating.controller;

import com.flixrating.FlixRating.model.Comments;
import com.flixrating.FlixRating.model.FlixRating;
import com.flixrating.FlixRating.repository.CommentsRepository;
import com.flixrating.FlixRating.repository.FlixRatingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/")
public class FlixRatingController {

    @Autowired
    private FlixRatingRepository flixRatingRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    @RequestMapping(value = "flixRatings", method = RequestMethod.GET)
    public List<FlixRating> list() {
        return flixRatingRepository.findAll();
    }

    @RequestMapping(value = "flixRatings", method = RequestMethod.POST)
    public FlixRating create(@RequestBody FlixRating flixRating) {
        return flixRatingRepository.saveAndFlush(flixRating);
    }

    @RequestMapping(value = "flixRatings/{id}", method = RequestMethod.GET)
    public FlixRating get(@PathVariable Long id) {
        return flixRatingRepository.findOne(id);
    }

    @RequestMapping(value = "flixRatings/{id}", method = RequestMethod.PUT)
    public FlixRating update(@PathVariable Long id, @RequestBody FlixRating flixRating) {
        FlixRating existingFlix = flixRatingRepository.findOne(id);
        BeanUtils.copyProperties(flixRating, existingFlix);
        return flixRatingRepository.saveAndFlush(existingFlix);
    }

    @RequestMapping(value = "flixRatings/{id}", method = RequestMethod.DELETE)
    public FlixRating delete(@PathVariable Long id) {
        FlixRating existingFlix = flixRatingRepository.findOne(id);
        flixRatingRepository.delete(existingFlix);
        return existingFlix;
    }

    @RequestMapping(value = "flixRatings/{id}", method = RequestMethod.POST)
    public FlixRating plusRating(@PathVariable Long id, @RequestBody FlixRating flixRating){
        FlixRating existingFlix = flixRatingRepository.findOne(id);
        Double rating = existingFlix.getAvgRating();
        rating+=1;
        flixRating.setAvgRating(rating);
        BeanUtils.copyProperties(flixRating, existingFlix);
        return flixRatingRepository.saveAndFlush(existingFlix);
    }

    @RequestMapping(value="flixRatings/comment", method = RequestMethod.POST)
    public Comments createComment(){
        Comments comment = new Comments();
//        Set comments = new HashSet<Comments>(){{
//            add(comment);
//        }};
//        FlixRating existingFlix = flixRatingRepository.findOne(id);
        comment.setUsername("UserNAME");
        comment.setMessage("HELLO WORLD");
        comment.setId(1L);
//        existingFlix.setComments(comments);
//        flixRatingRepository.saveAndFlush(existingFlix);
        return commentsRepository.saveAndFlush(comment);

    }
}
