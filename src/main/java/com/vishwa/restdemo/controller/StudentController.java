package com.vishwa.restdemo.controller;

import com.vishwa.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void createData()
    {
        students = new ArrayList<>();
        students.add(new Student("Vishwa", "G"));
        students.add(new Student("Rama", "K"));
        students.add(new Student("Sai", "N"));
        students.add(new Student("Kakk", "G"));
    }
    @GetMapping("/listStudents")
    public List<Student> getStudentsList()
    {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getData(@PathVariable int studentId)
    {

        if(studentId < 0 || (studentId > students.size()))
        {
            throw new StudentNotFoundException("Student id is not found" + studentId);
        }
        return students.get(studentId);
    }

}
