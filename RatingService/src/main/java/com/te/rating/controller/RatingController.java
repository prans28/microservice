package com.te.rating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.rating.dto.RatingDto;
import com.te.rating.response.Response;
import com.te.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/rating")
@RestController
public class RatingController {

	private final RatingService ratingService;

//create rating
	@PostMapping("/saveRating")
	public ResponseEntity<Response> saveRating(@RequestBody RatingDto ratingDto) {

		RatingDto rating = ratingService.createRating(ratingDto);
		return new ResponseEntity<Response>(new Response(false, "rating saved successfully", rating),
				HttpStatus.CREATED);
	}

//get all rating
	@GetMapping("/getAllRatings")
	public ResponseEntity<Response> getRatings() {

		List<RatingDto> ratings = ratingService.getAllRating();
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", ratings), HttpStatus.OK);
	}

//get all rating by user Id
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<Response> getRatingByUserId(@PathVariable String userId) {
		List<RatingDto> ratingsByUserId = ratingService.getRatingsByUserId(userId);
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", ratingsByUserId),
				HttpStatus.OK);
	}

//get all rating by hotel id	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Response> getRatingByHotelId(@PathVariable String hotelId) {
		List<RatingDto> ratingsByHotelId = ratingService.getRatingsByHotelId(hotelId);
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", ratingsByHotelId),
				HttpStatus.OK);
	}
}
