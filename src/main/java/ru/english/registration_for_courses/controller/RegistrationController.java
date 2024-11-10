package ru.english.registration_for_courses.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.english.registration_for_courses.dto.RegistrationDTO;
import ru.english.registration_for_courses.service.RegistrationFacade;
import java.util.List;
import java.util.UUID;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.english.registration_for_courses.entity.User;
import ru.english.registration_for_courses.repository.RoleRepository;
import ru.english.registration_for_courses.repository.UserRepository;

import java.util.Collections;


@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/registration")
@Slf4j
public class RegistrationController {

//    private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
    private final RegistrationFacade registrationFacade;

    @PostMapping("/save")
    public RegistrationDTO createRegistration(@RequestBody RegistrationDTO registration) {
        log.info("Сохраняем {}", registration);
        return registrationFacade.createRegistration(registration);
    }

    @GetMapping
    public List<RegistrationDTO> getAllRegistrations() {
        return registrationFacade.findAll();
    }

    @GetMapping("/{id}")
    public RegistrationDTO getById(@RequestParam UUID id) {
        return registrationFacade.findById(id);
    }

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singleton(roleRepository.findByName("ROLE_USER")));
        userRepository.save(user);
        return "redirect:/login";
    }




}
