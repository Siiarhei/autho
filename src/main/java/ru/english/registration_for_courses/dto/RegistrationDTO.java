package ru.english.registration_for_courses.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    private UUID id;
    private String courseName;
    private LocalDate date;
    private LocalTime time;
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String telegramNick;
}