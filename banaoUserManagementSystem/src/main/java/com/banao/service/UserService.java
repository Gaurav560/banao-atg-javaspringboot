package com.banao.service;

import com.banao.model.UserDetails;

public interface UserService {

	public UserDetails registerUserDetails(UserDetails userDetails) ;
		
	public boolean checkEmail(String email);
	
}
