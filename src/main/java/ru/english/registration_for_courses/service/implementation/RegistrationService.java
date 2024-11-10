package ru.english.registration_for_courses.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.english.registration_for_courses.entity.Registration;
import ru.english.registration_for_courses.repository.RegistrationRepository;
import ru.english.registration_for_courses.service.BaseCrudService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationService implements BaseCrudService<Registration> {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;  // Внедряем PasswordEncoder

    @Override
    public Registration save(Registration registration) {
        // Хешируем пароль перед сохранением
        String encodedPassword = passwordEncoder.encode(registration.getPassword());
        registration.setPassword(encodedPassword);

        return registrationRepository.save(registration);
    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration findById(UUID id) {
        return registrationRepository.getReferenceById(id);
    }
}
