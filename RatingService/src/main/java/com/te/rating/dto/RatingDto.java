package com.te.rating.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RatingDto {

	private String ratingId;
	private String userId;
	private String hotelId;
	
	private Integer rating;//i.e->1*, 2*
	private String feedBack;
}
