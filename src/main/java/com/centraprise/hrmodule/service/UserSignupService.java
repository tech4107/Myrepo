package com.centraprise.hrmodule.service;

import com.centraprise.hrmodule.model.User;
import com.centraprise.hrmodule.model.UserRegistration;

public interface UserSignupService {

	
	User findByusername(String username);

    User save(UserRegistration registration);
}
