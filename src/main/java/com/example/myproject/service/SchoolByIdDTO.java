package com.example.myproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import com.example.myproject.model.Student;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolByIdDTO implements Serializable {
    private Long id;

    private String schoolName;

    private List<Student> students;

	public void setId(Long schoolId) {
		// TODO Auto-generated method stub
		this.id = schoolId;
	}

	public void setSchoolName(String schoolName2) {
		// TODO Auto-generated method stub
		this.schoolName = schoolName2;
	}

	public void setStudents(List<Student> students2) {
		// TODO Auto-generated method stub
		this.students = students2;
	}
	public Long getId() {
		return this.id;
	}
	public String getSchoolName() {
		return this.schoolName;
	}
	public List<Student> getStudents() {
		return this.students;
	}
}
