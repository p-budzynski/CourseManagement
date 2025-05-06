package pl.kurs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.entity.Opinion;
import pl.kurs.repository.OpinionRepository;

@Service
@RequiredArgsConstructor
public class OpinionService {
    private final OpinionRepository opinionRepository;

    public void saveOpinion(Opinion opinion) {
        opinionRepository.save(opinion);
    }

    public void deleteOpinion(Long id) {
        opinionRepository.deleteById(id);
    }

}
