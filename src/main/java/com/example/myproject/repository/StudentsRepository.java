package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.School;
import com.example.myproject.model.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface StudentsRepository extends JpaRepository<Student, Long> {
    boolean existsBySchool(Optional<School> school);
    List<Student> findBySchoolId(Long schoolId);
	List<Student> findAll();

}