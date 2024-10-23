package com.jbk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jbk.entity.Subject;
import com.jbk.exception.CustomException;

@Repository
public class SubjectDaoimplement implements SubjectDaoInterface {

	@Autowired
	SessionFactory factory;

	@Override
	public String addSubject(Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			session.save(subject);
			session.getTransaction().commit();
			return "------ Subject data save Successfully-----";
		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace to debug
			throw new CustomException("Failed to add subject: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Subject> getAllSubjects() {
		Session session = null;
		List<Subject> list = null;
		try {
			session = factory.openSession();
			list = session.createCriteria(Subject.class).list();
			if (list == null) {
				throw new CustomException("try again something went wrong");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		Session session = null;
		Subject subject = null;
		try {
			session = factory.openSession();
			subject = session.get(Subject.class, subjectId);
			if (subject == null) {
				throw new CustomException("Subject not found with ID: " + subjectId);
			}
		} catch (Exception e) {
			throw new CustomException("Failed to retrieve subject: " + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return subject;
	}

	@Override
	public String deleteSubjectById(int subjectId) {
		Session session = null;
		Subject subject = null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			subject = session.get(Subject.class, subjectId);
			if (subject != null) {
				session.delete(subject);
				session.getTransaction().commit();
			}
			throw new CustomException("Subjrct not exist");

		} catch (Exception e) {
		} finally {
			session.close();
		}
		return "Subject deleted Successfully";
	}

	@Override
	public String updateSubject(Subject subject) {
		Session session = null;
		Subject existingsubject=null;
		try {
			session = factory.openSession();
			session.beginTransaction();
			existingsubject=session.get(Subject.class, subject.getSubjectId());
			if (existingsubject == null) {
				throw new CustomException("Subject not found");
			}
			existingsubject.setName(subject.getName());
			existingsubject.setCode(subject.getCode());
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {

		}
		 return "subject Update Successfully";
	}

}
