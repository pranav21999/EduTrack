package com.jbk.dao;

import java.util.List;

import com.jbk.entity.Student;

public interface StudentDaoInterface {
	public String addStudent(Student student);
	public List<Student> displayAllStudent();
	public String deleteStudentByRollNo(int rollNo);
	public Student GetStudentById(int RollNo);
	public String updateStudent(Student student);

}
