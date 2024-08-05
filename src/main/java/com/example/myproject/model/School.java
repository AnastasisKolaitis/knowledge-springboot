package com.example.myproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "schools")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "schoolname", nullable = false)
    private String schoolName;

	public String getSchoolName() {
		// TODO Auto-generated method stub
		return this.schoolName;
	}
	
	public Long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	public void setId(Long schoolId) {
		// TODO Auto-generated method stub
		this.id = schoolId;
	}

	public void setSchoolName(String schoolName2) {
		// TODO Auto-generated method stub
		this.schoolName = schoolName2; 
	}


}
