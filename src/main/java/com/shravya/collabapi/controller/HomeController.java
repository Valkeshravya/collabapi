package com.shravya.collabapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
	public HomeController() {
		System.out.println("Home Controller");
	}
@RequestMapping("/testing")
	public String test()
	{
		return "hello";
	}
}
