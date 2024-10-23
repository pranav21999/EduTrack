package com.jbk.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.dao.SubjectDaoInterface;
import com.jbk.entity.Subject;

@Service
public class SubjectServiceImplement  implements SubjectServiceInterface {

	@Autowired
	SubjectDaoInterface daoInterface;
	
	public String addSubject(Subject subject) {
		return daoInterface.addSubject(subject);
	}

	@Override
	public List<Subject> getAllSubjects() {
		// TODO Auto-generated method stub
		return daoInterface.getAllSubjects();
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return daoInterface.getSubjectById(subjectId);
	}

	@Override
	public String deleteSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return daoInterface.deleteSubjectById(subjectId);
	}

	@Override
	public String updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return daoInterface.updateSubject(subject);
	}

}
