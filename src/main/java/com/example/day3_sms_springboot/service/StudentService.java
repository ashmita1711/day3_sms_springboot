package com.example.day3_sms_springboot.service;

import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //CRUD operations--> Create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }
}