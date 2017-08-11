package com.flixrating.FlixRating.controller;


import com.flixrating.FlixRating.model.FlixRating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlixRatingStub {
	private static Map<Long, FlixRating> flixs = new HashMap<Long, FlixRating>();
	private static Long idIndex = 3L;

	//populate initial wrecks
	static {
		FlixRating a = new FlixRating(1L, "Shinning", "Stanley Kubrick's Masterpiece", 5.0, "Horror" );
		flixs.put(1L, a);
	}

	public static List<FlixRating> list() {
		return new ArrayList<FlixRating>(flixs.values());
	}

	public static FlixRating create(FlixRating flix) {
		idIndex += idIndex;
		flix.setId(idIndex);
		flixs.put(idIndex, flix);
		return flix;
	}

	public static FlixRating get(Long id) {
		return flixs.get(id);
	}

	public static FlixRating update(Long id, FlixRating flix) {
		flixs.put(id, flix);
		return flix;
	}

	public static FlixRating delete(Long id) {
		return flixs.remove(id);
	}
}
