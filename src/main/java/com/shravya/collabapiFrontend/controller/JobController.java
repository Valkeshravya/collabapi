package com.shravya.collabapiFrontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.model.Jobs;


@RestController
public class JobController 
{
@RequestMapping("/getJobs")
public List<Jobs> addJobs()
{
	Jobs job1=new Jobs();
	Jobs job2=new Jobs();
	job1.setJobRole("Developer");
	job1.setJobDiscription("FrontEnd");
	job1.setSalary("25000");
	job2.setJobRole("Developer");
	job2.setJobDiscription("Backend");
	job2.setSalary("30000");
	List<Jobs> list=new ArrayList<Jobs>();
	list.add(job1);
	list.add(job2);
	return list;
}
}
