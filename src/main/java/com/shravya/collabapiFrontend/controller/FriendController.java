package com.shravya.collabapiFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.daoImpl.FriendDaoImpl;
import com.shravya.collabapiBackend.model.Friend;
import com.shravya.collabapiBackend.model.User;

@RestController
public class FriendController 
{

	@Autowired
	FriendDaoImpl friendDaoImpl;
	@RequestMapping("/find")
	public List<User> getAllFriends()
	{
		List<User> list=friendDaoImpl.getAllFriends();
		return list;
	}
	
	@RequestMapping("/addFriend")
	public void addFriend(@RequestParam("fName") String fName,@RequestParam("uName") String uName)
	{
		System.out.println(fName);
		System.out.println(uName);
		Friend friend=new Friend();
		friend.setFriendName(fName);
		friend.setName(uName);
		friendDaoImpl.saveFriend(friend);
		//friendDaoImpl.saveFriend(fName);
	}
	
	@RequestMapping("/viewRequest")
	public List<Friend> getFriendRequest(@RequestParam("email") String friendName)
	{
		List<Friend> list=friendDaoImpl.viewFriendRequest(friendName);
		return list;
	}
	
	@RequestMapping("/myFriends")
	public List<Friend> getMyFriends(@RequestParam("email") String uName)
	{
		List<Friend> list=friendDaoImpl.getMyFriends(uName);
		return list;
	}
	
	@RequestMapping("/updateStatus")
	public String updateStatus(@RequestParam("fId") int friendId)
	{
		Friend friend=friendDaoImpl.getFriend(friendId);
		friend.setStatus(true);
		friendDaoImpl.updateFriend(friend);
		return "redirect:viewRequest";
	}
}

