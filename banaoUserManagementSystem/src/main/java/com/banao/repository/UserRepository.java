package com.banao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banao.model.UserDetails;

public interface UserRepository  extends JpaRepository<UserDetails,Integer> {
	
	public boolean existsByEmail(String email);

	
}
