package com.te.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
