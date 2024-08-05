package com.example.myproject.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.model.Student;
import com.example.myproject.repository.StudentsRepository;
import com.example.myproject.service.StudentDTO;
import com.example.myproject.service.StudentsService;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentsServiceImpl implements StudentsService {
    private final StudentsRepository studentsRepository;

    @Autowired
    public StudentsServiceImpl(
            StudentsRepository studentsRepository
    ) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentsRepository
                .findAll()
                .stream()
//                .sorted(Comparator.comparingLong(Student::getId))
                .toList();
    }

    @Override
    public Optional<Student> getStudent(Long studentId) {
        Optional<Student> optionalStudent = studentsRepository.findById(studentId);
        if (optionalStudent.isPresent()) return optionalStudent;
        else throw new EntityNotFoundException("Η εγργαφή δεν βρέθηκε");
    }

    @Override
    public Student save(Student student) {
        return studentsRepository.save(student);
    }

    @Override
    public void delete(Long studentId) {
        Optional<Student> optionalStudent = studentsRepository.findById(studentId);
        if (optionalStudent.isPresent()) studentsRepository.deleteById(studentId);
        else throw new EntityNotFoundException("Η εγγραφή δεν βρέθηκε");
    }

    @Override
    public Student update(Long studentId, StudentDTO studentDTO) {
        Optional<Student> optionalStudent = studentsRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = new Student();
            student.setId(studentId);
            student.setAm(studentDTO.getAm());
            student.setFirstName(studentDTO.getFirstName());
            student.setLastName(studentDTO.getLastName());
            student.setSchool(studentDTO.getSchool());
            return studentsRepository.save(student);
        } else throw new EntityNotFoundException("Η εγγραφή δεν βρέθηκε");
    }
}
