package ru.english.registration_for_courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.english.registration_for_courses.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
