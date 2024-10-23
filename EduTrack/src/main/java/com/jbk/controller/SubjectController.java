package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Subject;
import com.jbk.service.SubjectServiceInterface;

@RestController
public class SubjectController {
	@Autowired
	SubjectServiceInterface serviceInterface;
	
	@PostMapping("subject/add-subject")
	public String addSubject(@RequestBody Subject subject)
	{
		return serviceInterface.addSubject(subject);
	}
	
	@GetMapping("subject/display-allSubjects")
	public List<Subject> getAllSubjects()
	{
		return serviceInterface.getAllSubjects();
	}
	
	@GetMapping("subject/display-subject/{subjectId}")
	public Subject getSubjectById(@PathVariable int subjectId)
	{
		return serviceInterface.getSubjectById(subjectId);
	}
	
	
	@DeleteMapping("subject/delete-subject/{subjectId}")
	public String deleteSubjectById(@PathVariable int subjectId)	
	{
		return serviceInterface.deleteSubjectById(subjectId);
	}
	
	@PutMapping("subject/update-subject")
	public String updateSubject(@RequestBody Subject subject)
	{
		return  serviceInterface.updateSubject(subject);
	}
		
	}
	


