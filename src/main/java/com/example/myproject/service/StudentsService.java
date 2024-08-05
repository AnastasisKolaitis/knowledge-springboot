package com.example.myproject.service;

import java.util.List;
import java.util.Optional;

import com.example.myproject.model.Student;

public interface StudentsService {
    List<Student> getStudents();

    Optional<Student> getStudent(Long studentId);

    Student save(Student student);

    Student update(Long studentId, StudentDTO studentDTO);

    void delete(Long studentId);
}
