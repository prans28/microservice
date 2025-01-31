package com.te.hotel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.hotel.dto.HotelDto;
import com.te.hotel.response.Response;
import com.te.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hotel")
public class HotelController {

	private final HotelService hotelService;

//saving 	
	@PostMapping("/saveHotel")
	public ResponseEntity<Response> saveHotel(@RequestBody HotelDto hotelDto) {
		HotelDto saveHotel = hotelService.saveHotel(hotelDto);
		return new ResponseEntity<Response>(new Response(false, "saved successfully", saveHotel), HttpStatus.CREATED);
	}

//getting hotels	
	@GetMapping("/getHotels")
	public ResponseEntity<Response> getHotels() {
		List<HotelDto> allHotels = hotelService.getAllHotels();
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", allHotels), HttpStatus.OK);
	}

//getHotel by id
	@GetMapping("/getHotelById/{hotelId}")
	public ResponseEntity<Response> getHotelById(@PathVariable String hotelId) {
		HotelDto hotelDto = hotelService.getHotelById(hotelId);
		return new ResponseEntity<Response>(new Response(false, "fetched successfully", hotelDto), HttpStatus.OK);
	}
}
