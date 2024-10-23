package com.jbk.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.entity.Student;
import com.jbk.exception.CustomException;

@Repository
public class StudentDaoImplement implements StudentDaoInterface {

	@Autowired
	private SessionFactory factory;

	public String addStudent(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction(); // Start the transaction
			session.save(student); // Save the student object
			session.getTransaction().commit();
			return "Data Added Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to Add Data: " + e.getMessage();
		} finally {
			session.close(); // Ensure the session is closed

		}
	}

	public List<Student> displayAllStudent() {
		Session session = null;
		List<Student> listStudent = null;
		try {
			session = factory.openSession();
			listStudent = session.createCriteria(Student.class).list();
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception to debug further if needed
		} finally {
			if (session != null) {
				session.close(); // Ensure the session is closed
			}
		}
		return listStudent;
	}

	@Override
	public String deleteStudentByRollNo(int RollNo) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Student student = session.get(Student.class, RollNo);
			if (student != null) {
				session.delete(student);
				session.getTransaction().commit();
				return "Student Deleted Successfully";
			} else {
				return "Student Not Found";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to Delete Student: " + e.getMessage();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Student GetStudentById(int rollNo) {
		Session session = null;
		Student student = null;
		try {
			session = factory.openSession();
			student = session.get(Student.class, rollNo);
			if (student != null) {
				return student;
			} else
				throw new CustomException("Student not found with roll number: " + rollNo);

		} catch (Exception e) {
			throw new CustomException("Failed to retrieve student: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	@Override
	public String updateStudent(Student student) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			Student existingStudent = session.get(Student.class, student.getRollNo());

			if (existingStudent == null) {
				throw new CustomException("Student not found with roll number: " + student.getRollNo());
			}
			existingStudent.setStudentId(student.getStudentId());
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
			existingStudent.setEmail(student.getEmail());
			existingStudent.setPhoneNumber(student.getPhoneNumber());
			existingStudent.setAddress(student.getAddress());
			existingStudent.setDateOfBirth(student.getDateOfBirth());
			existingStudent.setDepartment(student.getDepartment());
			existingStudent.setClassName(student.getClassName());
			existingStudent.setGender(student.getGender());

			session.update(existingStudent);
			session.getTransaction().commit();
			return "Student updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException("Failed to update student: " + e.getMessage());
		} finally {
			session.close(); // Ensure the session is closed
		}
	}

}
