package com.example.myproject.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.example.myproject.model.School;
import com.example.myproject.model.Student;
import com.example.myproject.service.SchoolByIdDTO;
import com.example.myproject.service.SchoolDTO;
import com.example.myproject.service.SchoolsService;
import com.example.myproject.repository.StudentsRepository;
import com.example.myproject.repository.SchoolsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SchoolsServiceImpl implements SchoolsService {
	private final SchoolsRepository schoolsRespository;
	private final StudentsRepository studentsRepository;

	public SchoolsServiceImpl(SchoolsRepository schoolsRespository, StudentsRepository studentsRepository) {
		this.schoolsRespository = schoolsRespository;
		this.studentsRepository = studentsRepository;
	}

	@Override
	public List<School> getSchools() {
		return schoolsRespository.findAll().stream()
//                .sorted(Comparator.comparingLong(School::getId))
				.toList();
	}

	@Override
	public Optional<SchoolByIdDTO> getSchool(Long schoolId) {
		Optional<School> optionalSchool = schoolsRespository.findById(schoolId);
		if (optionalSchool.isPresent()) {
			List<Student> students = studentsRepository.findBySchoolId(schoolId);

			SchoolByIdDTO schoolByIdDTO = new SchoolByIdDTO();

			schoolByIdDTO.setId(schoolId);
			schoolByIdDTO.setSchoolName(optionalSchool.get().getSchoolName());
			schoolByIdDTO.setStudents(students);
			return Optional.of(schoolByIdDTO);
		} else
			throw new EntityNotFoundException("Η εγργαφή δεν βρέθηκε");
	}

	@Override
	public School save(School school) {
		return schoolsRespository.save(school);
	}

	@Override
	public void delete(Long schoolId) {
		Optional<School> optionalSchool = schoolsRespository.findById(schoolId);
		if (optionalSchool.isPresent()) {
			boolean hasStudents = studentsRepository.existsBySchool(optionalSchool);

			if (hasStudents)
				throw new RuntimeException(
						"Δεν μπορείτε να διαγράψετε το συγκεκριμένο σχολείο γιατί έχει ενεργούς μαθητές! Διαγράψτε πρώτα του μαθητές από την αναζήτηση μαθητών!");
			else
				schoolsRespository.deleteById(schoolId);
		} else
			throw new EntityNotFoundException("Η εγγραφή δεν βρέθηκε");
	}

	@Override
	public School update(Long schoolId, SchoolDTO schoolDTO) {
		Optional<School> optionalSchool = schoolsRespository.findById(schoolId);
		if (optionalSchool.isPresent()) {
			School school = new School();
			school.setId(schoolId);
			school.setSchoolName(schoolDTO.getSchoolName());
			return schoolsRespository.save(school);
		} else
			throw new EntityNotFoundException("Η εγγραφή δεν βρέθηκε");
	}
}
