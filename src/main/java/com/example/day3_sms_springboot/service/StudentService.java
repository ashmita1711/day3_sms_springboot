package com.example.day3_sms_springboot.service;

import com.example.day3_sms_springboot.dto.StudentRequestDto;
import com.example.day3_sms_springboot.dto.StudentResponseDto;
import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final  StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    //Create
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    //Display Student
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
        .stream()
        .map(s -> new StudentResponseDto(
                s.getId(),
                s.getName(),
                s.getAge(),
                s.getEmail()
        )).toList();
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

//    public StudentModel deleteById(String id){
//        StudentModel exising = repository.findById(id)
//                .orElseThrow(()-> new RuntimeException("No ID Found"));
//        repository.deleteById(id);
//        return exising;
//    }

    public StudentResponseDto deleteStudent(String id) {

        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        // Prepare response DTO before deleting
        StudentResponseDto response = new StudentResponseDto(
                existingStudent.getId(),
                existingStudent.getName(),
                existingStudent.getAge(),
                existingStudent.getEmail()
        );

        repository.delete(existingStudent);

        return response;
    }

}