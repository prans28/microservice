package com.te.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Hotel {
	
	@Id
	private String hotelId;
	private String hotelName;
	private String location;
	private String aboutHotel;
	

}
