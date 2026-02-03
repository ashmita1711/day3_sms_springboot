package com.example.day3_sms_springboot.controller;
import com.example.day3_sms_springboot.dto.StudentRequestDto;
import com.example.day3_sms_springboot.dto.StudentResponseDto;
import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    //create function API
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }

    //Display or read
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(){
        return service.getAllStudents();
    }

    //update (PUT)
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id , @RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    //Delete
    @DeleteMapping("/deleteId/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }

}