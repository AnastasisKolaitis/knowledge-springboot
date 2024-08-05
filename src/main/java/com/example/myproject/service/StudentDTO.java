package com.example.myproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import com.example.myproject.model.School;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements Serializable {
    private String firstName;
    private String lastName;
    private String am;
    private School school;
	public String getAm() {
		// TODO Auto-generated method stub
		return this.am;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.lastName;
	}
	public School getSchool() {
		// TODO Auto-generated method stub
		return this.school;
	}

}