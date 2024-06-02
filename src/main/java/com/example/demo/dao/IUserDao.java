package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojos.User;

public interface IUserDao extends JpaRepository<User, Integer> {
	
}
