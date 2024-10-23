package com.jbk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
    private int subjectId;
    private String name;
    private String code;

    // Default constructor
    public Subject() {
    }

    // Parameterized constructor
    public Subject(int subjectId, String name, String code) {
        this.subjectId = subjectId;
        this.name = name;
        this.code = code;
    }

    // Getters and Setters
    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // toString method
    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
