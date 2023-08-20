package com.pawar.config;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pawar.repo.UserRepository;
import com.pawar.model.User;


@Component
@Service
public class CustomDetailsService implements UserDetailsService,UserService {
 

	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<User> userinfo = repo.findByUsername(username);
	
	return userinfo.map(Userprincipal::new)
	.orElseThrow(()->new UsernameNotFoundException("user not found"+username));
		
	}
	

	 
	 @Override
	 public Optional<User> getUserByUsername(String username) {
		return repo.findByUsername(username);
		 
		 
	 }
	 
	 @Override
	 public User getUserById(Long userId) {
		return repo.findById(userId).orElse(null);
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}