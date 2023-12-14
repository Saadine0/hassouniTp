package com.example.SpringBootProject.controller;

import com.example.SpringBootProject.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
   // @GetMapping("student")
   @GetMapping
    public List<Student> getStudent_() {
        //Student student = new Student (
         //       1,
           //     "SaadEddine",
             //   "ElHimeur"
        //);

        List<Student> Students = new ArrayList<>();
        Students.add(new Student(1,"Saadeddine","Elhimeur"));
        Students.add(new Student(2,"Marouane","Elhissouf"));
        Students.add(new Student(3,"Mohammed","Malik"));
        Students.add(new Student(4,"Hamza","Ammazzal"));
        return Students;
    }
    @GetMapping("{id}")
    public Student studentPathVariable(@PathVariable("id") int StudentId){
       Student student = new Student(StudentId, "Saadeddine", "Elhimeur");
       return student;
    }

    @GetMapping("{id}/{first-name}/{last-name}")
    public Student studentPathVariable(
    @PathVariable("id") int studentId,
    @PathVariable("first-name") String firstName,
    @PathVariable("last-name") String lastName){
    Student student = new Student (studentId, firstName, lastName);
    return student;
    }
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id){
       Student student = new Student(id, "lwiyen", "publishing");
       return student;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
       System.out.println(student.getId());
       System.out.println(student.getFirstName());
       System.out.println(student.getLastName());
       return student;
    }


    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
       student.setId(studentId);
       System.out.println(student.getFirstName());
       System.out.println(student.getLastName());
       return student;
    }

    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
       System.out.println(studentId);
       return "Student deleted successfully!";
    }

    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
       Student student = new Student (
               1,
               "Saad",
               "elhimeur"
       );
       return ResponseEntity.ok()
               .header("Custom-header","Moha")
               .body(student);

    }










}
