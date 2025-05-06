package pl.kurs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.entity.User;
import pl.kurs.repository.UserRepository;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
