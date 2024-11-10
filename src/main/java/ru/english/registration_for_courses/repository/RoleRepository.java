package ru.english.registration_for_courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.english.registration_for_courses.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
