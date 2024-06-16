package com.te.user.services.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class AppUser {

	@Id
	@Column(name = "id", nullable = false)
	private String userId;
	
	private String name;
	private String email;
	private String about;
	
	@Transient
	List<Rating>  ratings;
}
