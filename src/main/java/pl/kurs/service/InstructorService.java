package pl.kurs.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.entity.Instructor;
import pl.kurs.repository.InstructorRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public void saveInstructor(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

}
