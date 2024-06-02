package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojos.User;
import com.example.demo.services.IUserService;

import ch.qos.logback.core.status.Status;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userSrv;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signIn(@RequestBody User u){
		System.out.println("inside signin");
		User ur=userSrv.signIn(u.getEmail(), u.getPswd());
		return new ResponseEntity<>(ur,HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<?>signUp(@RequestBody User u){
		System.out.println("inside signup");
		User ur=userSrv.signUp(u);
		return new ResponseEntity<>(ur,HttpStatus.OK);
	}
	@GetMapping("/getUsers")
	public ResponseEntity<?>getAllUsers(){
		System.out.println("getUsers");
		return new ResponseEntity<>(userSrv.getAllUsers(),HttpStatus.OK);
	}
}
