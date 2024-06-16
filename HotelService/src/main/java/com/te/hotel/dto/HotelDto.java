package com.te.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HotelDto {

	private String hotelId;
	private String hotelName;
	private String location;
	private String aboutHotel;
}
