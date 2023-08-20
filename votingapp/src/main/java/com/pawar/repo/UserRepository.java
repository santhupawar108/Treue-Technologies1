package com.pawar.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pawar.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	
	User getLoggedInUser();

}
