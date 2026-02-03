package com.example.day3_sms_springboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@Data // automatically make getter and setters for everyone
@Getter
@Setter
@AllArgsConstructor //automatically make constructors for everyone
@NoArgsConstructor // (optional) used for making empty constructor
@Document(collection = "students")

public class StudentModel {
    @Id  //used to make primary key
    private String id;

    private String name;
    private int age;
    private String email;
}
