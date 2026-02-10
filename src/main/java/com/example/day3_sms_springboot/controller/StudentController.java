package com.example.day3_sms_springboot.controller;
import com.example.day3_sms_springboot.dto.StudentRequestDto;
import com.example.day3_sms_springboot.dto.StudentResponseDto;
import com.example.day3_sms_springboot.service.StudentService;
import com.example.day3_sms_springboot.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
    private final StudentService service;
    private final JwtUtil jwtUtil;

    public StudentController(StudentService service, JwtUtil jwtUtil)
    {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    private void checkToken(String authHeader){
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid token");
        }
        String token=authHeader.substring(7);
        jwtUtil.validateTokenAndGetEmail(token);
    }

    //create function API
    @PostMapping("/add-student")
    public StudentResponseDto addStudent(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody StudentRequestDto student){
        checkToken(authHeader);
        return service.addStudent(student);
    }

    //Display or read
    @GetMapping("/students")
    public List<StudentResponseDto> getStudents(
            @RequestHeader(value = "Authorization", required = false)String authHeader){
        checkToken(authHeader);
        return service.getAllStudents();
    }

    //update (PUT)
    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id , @RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }

    //Delete
    @DeleteMapping("/deleteId/{id}")
    public StudentResponseDto deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }

    @PatchMapping("/patch/{id}")
    public StudentResponseDto patchStudent(@PathVariable String id,
                                           @RequestBody Map<String, Object> updates) {
        return service.patchStudent(id, updates);
    }

}