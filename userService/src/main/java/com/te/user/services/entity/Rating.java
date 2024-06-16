package com.te.user.services.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	
	private Integer rating;//i.e->1*, 2*
	private String feedBack;
	
	
}
