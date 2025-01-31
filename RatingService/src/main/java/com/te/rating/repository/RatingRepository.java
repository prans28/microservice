package com.te.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.rating.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String> {

	// get rating by user Id(custom method)
	List<Rating> findByUserId(String userId);

	// get rating by Hotel Id(custom method)
	List<Rating> findByHotelId(String hotelId);

}
