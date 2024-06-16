package com.te.user.services.services.extra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.te.user.services.entity.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

	@GetMapping(path = "/getHotelById/{hotelId}")
	Hotel getHotelById(@PathVariable String hotelId);
	
}
