package com.example.demo.services;

import java.util.List;

import com.example.demo.pojos.User;

public interface IUserService {

	public User signIn(String email,String pswd);
	public User signUp(User u);
	public List<User> getAllUsers();
	
}
