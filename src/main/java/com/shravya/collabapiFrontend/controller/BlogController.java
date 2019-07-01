package com.shravya.collabapiFrontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.model.Blog;



@RestController
public class BlogController 
{
@RequestMapping("/getblogs")
public List<Blog> addBlogs()
{
	Blog blog1=new Blog();
	Blog blog2=new Blog();
	blog1.setBlogTitle("abc");
	blog1.setBlogName("bc");
	blog1.setBlogOwner("c");
	blog2.setBlogTitle("bbc");
	blog2.setBlogName("a");
	blog2.setBlogOwner("r");
	List<Blog> list=new ArrayList<Blog>();
	list.add(blog1);
    list.add(blog2);
	return list;
}
}
