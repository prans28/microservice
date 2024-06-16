package com.te.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.te.hotel.dto.HotelDto;
import com.te.hotel.entity.Hotel;
import com.te.hotel.exception.ResourceNotFoundException;
import com.te.hotel.repository.HotelRepository;
import com.te.hotel.service.HotelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepository;

	@Override
	public HotelDto saveHotel(HotelDto hotelDto) {
		Hotel hotel = new Hotel();
		String randomHotelId = UUID.randomUUID().toString();
		hotelDto.setHotelId(randomHotelId);
		BeanUtils.copyProperties(hotelDto, hotel);
		hotelRepository.save(hotel);
		return hotelDto;
	}

	@Override
	public List<HotelDto> getAllHotels() {
		List<Hotel> hotels = hotelRepository.findAll();

		List<HotelDto> list = new ArrayList<HotelDto>();
		if (hotels == null) {
			throw new ResourceNotFoundException("hotel not found");
		} else {

			hotels.stream().forEach((hotel) -> {
				HotelDto hotelDto = new HotelDto();

				String randomHotelId = UUID.randomUUID().toString();
				hotelDto.setHotelId(randomHotelId);
				BeanUtils.copyProperties(hotel, hotelDto);
				list.add(hotelDto);
			});

		}
		return list;
	}

	@Override
	public HotelDto getHotelById(String hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("hotel not available with this ID: " + hotelId));
		HotelDto hotelDto = new HotelDto();
		BeanUtils.copyProperties(hotel, hotelDto);
		return hotelDto;
	}

}
