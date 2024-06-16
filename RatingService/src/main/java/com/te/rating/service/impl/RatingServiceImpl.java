package com.te.rating.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.rating.dto.RatingDto;
import com.te.rating.entity.Rating;
import com.te.rating.exception.ResourceNotFoundException;
import com.te.rating.repository.RatingRepository;
import com.te.rating.service.RatingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

	private final RatingRepository ratingRepository;

//saving rating	
	@Override
	public RatingDto createRating(RatingDto ratingDto) {
		Rating rating = new Rating();
		String randomRatingId = UUID.randomUUID().toString();
		ratingDto.setRatingId(randomRatingId);
		BeanUtils.copyProperties(ratingDto, rating);
		ratingRepository.save(rating);

		return ratingDto;
	}

//getting all rating	
	@Override
	public List<RatingDto> getAllRating() {

		List<Rating> ratings = ratingRepository.findAll();
		List<RatingDto> ratingDtosList = new ArrayList<RatingDto>() ;
		
		if(ratings.isEmpty()) {
			throw new ResourceNotFoundException("no rating found");
		}else {
			ratings.stream().forEach((rating)->{
				RatingDto ratingDto = new RatingDto();
				BeanUtils.copyProperties(rating, ratingDto);
				ratingDtosList.add(ratingDto);
				
			});
		}
		return ratingDtosList;
	}

	@Override
	public List<RatingDto> getRatingsByUserId(String userId) {
		
		List<Rating> ratingByUserId = ratingRepository.findByUserId(userId);
		List<RatingDto> list = new ArrayList<>();
		if(ratingByUserId.isEmpty()) {
			throw new ResourceNotFoundException("rating not available for given userId"+ratingByUserId);
		}else {
			ratingByUserId.stream().forEach((rating)->{
				RatingDto ratingDto = new RatingDto();
				BeanUtils.copyProperties(rating, ratingDto);
				list.add(ratingDto);
			});
		}
		
		return list;
	}

	@Override
	public List<RatingDto> getRatingsByHotelId(String hotelId) {
		
		List<Rating> ratingByHotelId = ratingRepository.findByHotelId(hotelId);
		List<RatingDto> list = new ArrayList<>();
		if(ratingByHotelId.isEmpty()) {
			throw new ResourceNotFoundException("rating not available for given HotelId"+ratingByHotelId);
		}else {
			ratingByHotelId.stream().forEach((rating)->{
				RatingDto ratingDto = new RatingDto();
				BeanUtils.copyProperties(rating, ratingDto);
				list.add(ratingDto);
			});
		}
		
		return list;
	}

}
