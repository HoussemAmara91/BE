package com.example.demo;

import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("users")
public class userController {
	@Autowired
	UserDAO userDAO;
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public User AddUser(User user)
	{
		return userDAO.AddUser(user);
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestBody Map<String, String> json) throws ServletException {
		return userDAO.login(json);
	}

}
