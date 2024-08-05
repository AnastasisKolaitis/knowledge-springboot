package com.example.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.myproject.model.Student;
import com.example.myproject.service.StudentDTO;
import com.example.myproject.service.StudentsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/students")

public class StudentsController {

    private final StudentsService studentsService;

    @Autowired
    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Student>> getStudents() {
        System.out.println("Starting MyProjectApplication...");
        return ResponseEntity
                .ok()
                .body(studentsService.getStudents());
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Optional<Student>> getStudent(@PathVariable Long studentId) {
        return ResponseEntity
                .ok()
                .body(studentsService.getStudent(studentId));
    }

    @PostMapping(path = "")
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return ResponseEntity
                .ok()
                .body(studentsService.save(student));
    }

    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<Void> delete(@PathVariable Long studentId) {
        studentsService.delete(studentId);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping(path = "{studentId}")
    public ResponseEntity<Student> update(
            @PathVariable Long studentId,
            @RequestBody StudentDTO studentDTO
    ) {
        return ResponseEntity
                .ok()
                .body(studentsService.update(studentId, studentDTO));
    }

}
