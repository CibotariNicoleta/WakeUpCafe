package com.start.database;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.start.loginAndRegistration.User;
import com.start.loginAndRegistration.UserRegistrationDto;


public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
}
