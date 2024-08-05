package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.School;

public interface SchoolsRepository extends JpaRepository<School, Long> {
}