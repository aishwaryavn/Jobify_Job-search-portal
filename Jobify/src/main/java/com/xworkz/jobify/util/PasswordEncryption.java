package com.xworkz.jobify.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryption {
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	
	
	public String encryptPassword(String password) {
		return passwordEncoder.encode(password);
	}

}

