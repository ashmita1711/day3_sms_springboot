package com.example.day3_sms_springboot.controller;
import com.example.day3_sms_springboot.repository.StudentRepository;
import com.example.day3_sms_springboot.model.StudentModel;
import com.example.day3_sms_springboot.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service, StudentRepository StudentRepository) {
        this.service = service;
    }

    //create function API
    @PostMapping("/add-student")
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }

    //Display or read
    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }

    //update (PUT)
    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id , @RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    //Delete
    @DeleteMapping("/deleteId/{id}")
    public StudentModel deleteById(@PathVariable String id){
        return service.deleteById(id);
    }

}