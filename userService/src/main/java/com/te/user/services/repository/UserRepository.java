package com.te.user.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.user.services.entity.AppUser;

public interface UserRepository  extends JpaRepository<AppUser, String>{

	//if you want to use custom method or query method then we will write here	
}
