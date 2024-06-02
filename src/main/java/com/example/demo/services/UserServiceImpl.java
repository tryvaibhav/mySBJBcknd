package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IUserDao;
import com.example.demo.pojos.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao usrDao;

	@Override
	public User signIn(String email, String pswd) {
		// TODO Auto-generated method stub
		List<User>ul = usrDao.findAll();
//		Stream<User> us=ul.stream();
//		us.filter(u->compare(u.getEmail(),email,u.getPswd(),pswd));
		for (User user : ul) {
			if(user.getEmail().equals(email) && user.getPswd().equals(pswd))return user;
		}
		return null;
	}
//	public boolean compare(String s1,String s2,String s3,String s4) {
//		return s1.equals(s2) && s3.equals(s4);
//	}

	@Override
	public User signUp(User u) {
		return usrDao.save(u);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usrDao.findAll();
	}
	
}
