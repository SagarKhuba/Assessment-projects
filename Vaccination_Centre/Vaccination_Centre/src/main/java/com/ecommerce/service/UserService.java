package com.ecommerce.service;

import org.springframework.stereotype.Service; 

import com.ecommerce.entity.User; 
import com.ecommerce.repository.UserRepository; 
  
@Service 
public class UserService { 
private final UserRepository userRepository; 
  
public UserService(UserRepository userRepository) { 
this.userRepository = userRepository; 
} 
  
public void registerUser(User user) { 
userRepository.save(user); 
} 
} 