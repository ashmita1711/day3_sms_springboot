package com.example.day3_sms_springboot.dto;

public record StudentResponseDto(
        String id,
        String name,
        int age,
        String email
) {
}
