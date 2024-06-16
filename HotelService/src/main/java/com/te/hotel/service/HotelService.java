package com.te.hotel.service;

import java.util.List;

import com.te.hotel.dto.HotelDto;

public interface HotelService {

	//create Hotel
	HotelDto saveHotel(HotelDto hotelDto);
	
	//get All Hotel
	List<HotelDto> getAllHotels();
	
	//get HotelById
	HotelDto getHotelById(String hotelId);
}
