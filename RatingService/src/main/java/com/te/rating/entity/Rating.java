package com.te.rating.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user_Rating")
public class Rating {

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	
	private Integer rating;//i.e->1*, 2*
	private String feedBack;
}
