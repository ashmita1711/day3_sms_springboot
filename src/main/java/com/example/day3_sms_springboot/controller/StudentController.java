package com.example.day3_sms_springboot.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //Creating function API
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){

        return service.addStudent(student);
    }
}