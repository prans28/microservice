package com.te.rating.service;

import java.util.List;

import com.te.rating.dto.RatingDto;

public interface RatingService {

	
	//create
	RatingDto createRating(RatingDto ratingDto); 
		
	//get all ratings
	List<RatingDto> getAllRating();
	
	//get all rating by user Id
	List<RatingDto> getRatingsByUserId(String userId);
	
	//get all Rating by hotelId
	List<RatingDto> getRatingsByHotelId(String hotelId);
}
