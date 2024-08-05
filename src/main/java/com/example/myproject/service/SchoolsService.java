package com.example.myproject.service;

import java.util.List;
import java.util.Optional;

import com.example.myproject.model.School;

public interface SchoolsService {
    List<School> getSchools();

    Optional<SchoolByIdDTO> getSchool(Long schoolId);

    School save(School school);

    School update(Long schoolId, SchoolDTO schoolDTO);

    void delete(Long schoolId);
}
