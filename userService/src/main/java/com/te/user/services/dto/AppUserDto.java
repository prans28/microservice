package com.te.user.services.dto;

import java.util.List;

import com.te.user.services.entity.Rating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AppUserDto {
	
	private String userId;
	private String name;
	private String email;
	private String about;
	
	List<Rating>  ratings;
}
