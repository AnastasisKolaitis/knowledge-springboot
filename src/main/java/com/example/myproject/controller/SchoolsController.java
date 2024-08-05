package com.example.myproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.myproject.model.School;
import com.example.myproject.service.SchoolByIdDTO;
import com.example.myproject.service.SchoolDTO;
import com.example.myproject.service.SchoolsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/schools")
public class SchoolsController {

    private final SchoolsService schoolsService;

    @Autowired
    public SchoolsController(SchoolsService schoolsService) {
        this.schoolsService = schoolsService;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<School>> getSchools() {
        return ResponseEntity
                .ok()
                .body(schoolsService.getSchools());
    }

    @GetMapping(path = "/{schoolId}")
    public ResponseEntity<Optional<SchoolByIdDTO>> getSchool(@PathVariable Long schoolId) {
        return ResponseEntity
                .ok()
                .body(schoolsService.getSchool(schoolId));
    }

    @PostMapping(path = "")
    public ResponseEntity<School> save(@RequestBody School school) {
        return ResponseEntity
                .ok()
                .body(schoolsService.save(school));
    }

    @DeleteMapping(path = "{schoolId}")
    public ResponseEntity<Void> delete(@PathVariable Long schoolId) {
        schoolsService.delete(schoolId);
        return ResponseEntity
                .ok()
                .build();
    }

    @PutMapping(path = "{schoolId}")
    public ResponseEntity<School> update(
            @PathVariable Long schoolId,
            @RequestBody SchoolDTO schoolDTO
    ) {
        return ResponseEntity
                .ok()
                .body(schoolsService.update(schoolId, schoolDTO));
    }

}
