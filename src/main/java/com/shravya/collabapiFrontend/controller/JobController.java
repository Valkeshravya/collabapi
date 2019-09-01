package com.shravya.collabapiFrontend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shravya.collabapiBackend.daoImpl.JobsDaoImpl;
import com.shravya.collabapiBackend.model.Jobs;


@RestController
public class JobController 
{
	@Autowired
	JobsDaoImpl jobsDaoImpl;
@PostMapping("/addJobs")
public void addJobs(@RequestBody Jobs jobs)
{
	jobsDaoImpl.addJobs(jobs);
}
@RequestMapping("/getJobs")
public List<Jobs> getAllJobs()
{
	List<Jobs> list=jobsDaoImpl.getAllJobs();
	return list;
}
@RequestMapping("/editJob")
public List<Jobs> applyJob(@RequestParam("jobId") int jobId)
{
	System.out.println(jobId);
	Jobs jobs=jobsDaoImpl.getJob(jobId);
	jobs.setEnable(true);
	jobsDaoImpl.editJob(jobs);
	List<Jobs> list=jobsDaoImpl.getAllJobs();
	return list;
}

@RequestMapping("/deleteJob")
public String deleteJob(@RequestParam("jId") int jobId)
{
	Jobs jobs=jobsDaoImpl.getJob(jobId);
	jobsDaoImpl.deleteJob(jobs);
  	return "redirect:getJobs";
}

}
