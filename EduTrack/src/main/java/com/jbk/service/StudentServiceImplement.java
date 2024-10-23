package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.jbk.dao.StudentDaoInterface;
import com.jbk.entity.Student;

@Component
public class StudentServiceImplement implements StudentServiceInterface {

	@Autowired
	StudentDaoInterface daoInterface;

	@Override
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		return daoInterface.addStudent(student);
	}

	@Override
	public List<Student> displayAllStudent() {
		// TODO Auto-generated method stub
		return daoInterface.displayAllStudent();
	}

	@Override
	public String deleteStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		return daoInterface.deleteStudentByRollNo(rollNo);
	}

	@Override
	public Student GetStudentById(int rollNo) {
		// TODO Auto-generated method stub
		return daoInterface.GetStudentById(rollNo);
	}

	@Override
	public String updateStudent(Student student) {
		// TODO Auto-generated method stub
		return daoInterface.updateStudent(student);
	}

}
