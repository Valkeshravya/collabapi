package com.shravya.collabapiFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.daoImpl.UserDaoImpl;
import com.shravya.collabapiBackend.model.User;
@RestController
public class UserController
{
	@Autowired
	UserDaoImpl userDaoImpl;
@PostMapping("/adduser")
	public void addUser(@RequestBody User user)
	{
		userDaoImpl.addUser(user);
		System.out.println(user.getUserName());
		System.out.println("adduser-------"+user.getRole());
	}

@PostMapping("/login")
public int checkLogin(@RequestBody User user)
{
	boolean result=userDaoImpl.checkLogin(user);
	User usr=userDaoImpl.getUser(user.getEmail());
	String role=usr.getRole();
	System.out.println(role);
	if(result==true)
	{
		if(role.equals("ROLE_USER"))
		{
		System.out.println("login Success");
		return 1;
		}
		else 
		{
			return 2;
		}
	}
	
	else
	{
		System.out.println("loginfailed");
		return 0;
	}
	
}
}

