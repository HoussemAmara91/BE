package com.example.demo;

import java.util.Map;

import javax.servlet.ServletException;

public interface UserDAO {
	
	User AddUser(User user);
	String login( Map<String, String> json) throws ServletException;
	
}
