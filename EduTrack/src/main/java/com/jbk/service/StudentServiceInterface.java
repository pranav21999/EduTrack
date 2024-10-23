package com.jbk.service;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentServiceInterface {

	public String addStudent(Student student);

	public List<Student> displayAllStudent();
	public String deleteStudentByRollNo(int rollNo);

	public Student GetStudentById(int rollNo);

	public String updateStudent(Student student);



}
