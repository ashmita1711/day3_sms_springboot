package com.example.day3_sms_springboot.service;

import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final  StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //Create
    public StudentModel addStudent(StudentModel student){
        return repository.save(student);
    }

    //Display Student

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }

    //Update
    public StudentModel updateStudent(String id , StudentModel student){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("No Student Found"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setEmail(student.getEmail());

        return repository.save(existingStudent);

    }

    public StudentModel deleteById(String id){
        StudentModel existingid = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("No ID Found"));
        repository.deleteById(id);
        return existingid;
    }
}