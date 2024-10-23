package com.jbk.dao;
import java.util.List;

import com.jbk.entity.Subject;

public interface SubjectDaoInterface {

	
	public String addSubject(Subject subject);

	public List<Subject> getAllSubjects();

	public Subject getSubjectById(int subjectId);

	public String deleteSubjectById(int subjectId);

	public String updateSubject(Subject subject);

	
	
}
