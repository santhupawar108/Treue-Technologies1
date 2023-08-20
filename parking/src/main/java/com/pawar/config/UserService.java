package com.pawar.config;

import java.util.Optional;

import com.pawar.model.User;

public interface UserService {

	Optional<User> getUserByUsername(String username);

	User getUserById(Long userId);
	
	//User getUserByUsername(String username);
	
	//User getUserById(Long userId);

}
