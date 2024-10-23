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
import com.jbk.entity.Student;
import com.jbk.service.StudentServiceInterface;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterface serviceInterface;

	@PostMapping("/student/add-student")
	public String addStudent(@RequestBody Student student)
	{
		return serviceInterface.addStudent(student);
	}
	
	@GetMapping("/student/display-Allstudent")
	public List<Student> displayAllStudent()
	{
		return serviceInterface.displayAllStudent();
	}
	
	@GetMapping("student/display-student/{rollNo}")
	public Student GetStudentById(@PathVariable int rollNo)
	{
		return serviceInterface.GetStudentById(rollNo);
	}
	
	@PutMapping("student/update-student")
	public String  updateStudent(@RequestBody Student student)
	{	
		return  serviceInterface.updateStudent(student);
	}
	
	@DeleteMapping("student/delete-student/{RollNo}")
	public String deleteStudentByRollNo(@PathVariable int RollNo)
	{
		return serviceInterface.deleteStudentByRollNo(RollNo);
	}
	
}
