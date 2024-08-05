package com.example.myproject.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO implements Serializable {
    private String schoolName;

	public String getSchoolName() {
		// TODO Auto-generated method stub
		return this.schoolName;
	}
}