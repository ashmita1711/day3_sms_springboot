package com.example.day3_sms_springboot.repository;

import com.example.day3_sms_springboot.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository <StudentModel, String> {

}
