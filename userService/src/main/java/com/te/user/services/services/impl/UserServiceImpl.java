package com.te.user.services.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.te.user.services.dto.AppUserDto;
import com.te.user.services.entity.AppUser;
import com.te.user.services.entity.Rating;
import com.te.user.services.exception.ResourceNotFoundException;
import com.te.user.services.repository.UserRepository;
import com.te.user.services.services.UserService;
import com.te.user.services.services.extra.HotelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RestTemplate restTemplate;
	private final HotelService hotelService;

	@Override
	public AppUserDto saveUser(AppUserDto userAppDto) {
		AppUser appUser = new AppUser();
		String randomUserId = UUID.randomUUID().toString();
		userAppDto.setUserId(randomUserId);
		BeanUtils.copyProperties(userAppDto, appUser);
		userRepository.save(appUser);
		log.info("Saved user with ID: {}", randomUserId);
		return userAppDto;
	}

	@Override
	public List<AppUserDto> getAllUser() {
		List<AppUser> users = userRepository.findAll();
		List<AppUserDto> dtosList = new ArrayList<>();

		if (users == null || users.isEmpty()) {
			log.warn("No users found in the database.");
			throw new ResourceNotFoundException("User not available");
		} else {
			users.forEach(user -> {
				AppUserDto appUserDto = new AppUserDto();
				BeanUtils.copyProperties(user, appUserDto);
				dtosList.add(appUserDto);
			});
			log.info("Fetched {} users from the database.", users.size());
		}
		return dtosList;
	}

	@Override
	public AppUserDto getUserById(String userId) {
	    AppUser appUser = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));

	    AppUserDto userDto = new AppUserDto();
	    BeanUtils.copyProperties(appUser, userDto);

	    
	    //here we will communicate between two services
	    return userDto;

	}	

}











//try {
//// Correctly construct the URL
//String url = "http://localhost:8082/rating/user/" + userId;
//ArrayList<Rating> ratings = restTemplate.getForObject(url, ArrayList.class);
//userDto.setRatings(ratings); // Set the ratings in the DTO
//log.info("Fetched ratings for user {}: {}", userId, ratings);
//} catch (HttpClientErrorException e) {
//if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
//    log.warn("Ratings not available for userId: {}", userId);
//} else {
//    log.error("Error fetching ratings for userId: {}", userId, e);
//    throw e;
//}
//}
