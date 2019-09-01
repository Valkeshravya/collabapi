package com.shravya.collabapiFrontend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.daoImpl.BlogDaoImpl;
import com.shravya.collabapiBackend.model.Blog;



@RestController
public class BlogController 
{
@Autowired
BlogDaoImpl blogDaoImpl;
	
@RequestMapping("/getAppblogs")
public List<Blog> getApprovedBlogs()
{
	
	List<Blog> list=blogDaoImpl.getApprovedBlogs();
	System.out.println(" list of blogs-------"+list);
	return list;
}
@RequestMapping("/getUnAppBlogs")
public List<Blog> getUnApprovedBlogs()
{
	List<Blog> list=blogDaoImpl.getUnApprovedBlogs();
	System.out.println("UNAPPROVED BLOGS"+list);
	return list;
}

@RequestMapping("/updateBlog")
public List<Blog> approveBlog(@RequestParam("bId") int blogId)
{

    System.out.println(blogId);
    Blog blog=blogDaoImpl.getBlog(blogId);
    blog.setEnabled(true);
    blogDaoImpl.editBlog(blog);
    List<Blog> list=blogDaoImpl.getUnApprovedBlogs();
	return list;
}

@PostMapping("/addblog")
public void addBlogs(@RequestBody Blog blog)
{
	blogDaoImpl.addBlog(blog);
	System.out.println(blog.getBlogName());
}
@RequestMapping("/getMyblogs")
public List<Blog> getMyBlogs(@RequestParam("email") String emailId)
{
	List<Blog> list=blogDaoImpl.getMyBlogs(emailId);
	System.out.println("in my blog contrllr---"+emailId);
	return list;
}

@RequestMapping("/delete")
public String deleteBlog(@RequestParam("id") int blogId)
{
	Blog blog=blogDaoImpl.getBlog(blogId);
	blogDaoImpl.deleteBlog(blog);
	return "redirect:getMyblogs";
}
}
