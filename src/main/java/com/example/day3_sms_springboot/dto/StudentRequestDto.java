package com.example.day3_sms_springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {

    @NotBlank(message = "Name can't be blank")
    private String name;

    @Min(value = 5, message = "Age can't be less than 5")
    @Max(value = 90, message = "Age can't be more than 90")
    private Integer age;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email can't be blank")
    private String email;
}
