package com.example.demo;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;

@Service
public class UserService implements UserDAO{

	@Autowired
	UserRepository userRepo;
	@Override
	public User AddUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String login(Map<String, String> json) throws ServletException {
		if (json.get("username") == null || json.get("password") == null) {
			throw new ServletException("Please fill in username and password");
		}

		String userName = json.get("username");
		String password = json.get("password");

		User user = userRepo.findOneByUsername(userName);

		if (user == null) {
			throw new ServletException("User name not found.");
		}

		String pwd = user.getPwd();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your username and password");
		}

		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
	}


	

}
