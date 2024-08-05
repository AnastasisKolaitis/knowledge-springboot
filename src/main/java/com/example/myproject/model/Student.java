package com.example.myproject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @Column(name = "AM")
    private String am;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

	public void setId(Long studentId) {
		this.id = studentId;
	}

	public void setAm(String am2) {
		// TODO Auto-generated method stub
		this.am = am2;
	}

	public void setFirstName(String firstName2) {
		// TODO Auto-generated method stub
		this.firstName = firstName2;
	}

	public void setLastName(String lastName2) {
		// TODO Auto-generated method stub
		this.lastName = lastName2;
	}

	public void setSchool(School school2) {
		// TODO Auto-generated method stub
		this.school = school2;
	}

	public Long getId() {
		return this.id;
	}
	public String getAm() {
		return this.am;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public School getSchool() {
		return this.school;
	}
}
