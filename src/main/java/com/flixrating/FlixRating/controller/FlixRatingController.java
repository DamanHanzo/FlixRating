package com.flixrating.FlixRating.controller;

import com.flixrating.FlixRating.model.FlixRating;
import com.flixrating.FlixRating.repository.FlixRatingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class FlixRatingController {

    @Autowired
    private FlixRatingRepository flixRatingRepository;

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
        FlixRating existingShipwreck = flixRatingRepository.findOne(id);
        BeanUtils.copyProperties(flixRating, existingShipwreck);
        return flixRatingRepository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "flixRatings/{id}", method = RequestMethod.DELETE)
    public FlixRating delete(@PathVariable Long id) {
        FlixRating existingShipwreck = flixRatingRepository.findOne(id);
        flixRatingRepository.delete(existingShipwreck);
        return existingShipwreck;
    }

}
