package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String id ;
	
	private String firstName;
	private String lastNale;
	private String login ;
	private String pwd ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNale() {
		return lastNale;
	}
	public void setLastNale(String lastNale) {
		this.lastNale = lastNale;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public User(String firstName, String lastNale, String login, String pwd) {
		super();
		this.firstName = firstName;
		this.lastNale = lastNale;
		this.login = login;
		this.pwd = pwd;
	}
	
	
	

}
