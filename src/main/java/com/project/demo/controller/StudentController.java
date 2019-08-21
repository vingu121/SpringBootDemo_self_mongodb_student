package com.project.demo.controller;

import com.project.demo.domain.Student;
import com.project.demo.exception.StudentAlreadyExistsException;
import com.project.demo.exception.StudentDoesnotExistsException;
import com.project.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/api/stu")
public class StudentController {

    private StudentService studentService;
    ResponseEntity responseEntity;

    @Autowired
   public StudentController (StudentService studentService){
      this.studentService = studentService;
  }

  @PostMapping("student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) throws StudentAlreadyExistsException{

        try {
             studentService.saveStudent(student);
             responseEntity = new ResponseEntity<Student>(student,HttpStatus.CREATED);
        }
        catch (StudentAlreadyExistsException e){
            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;

    }

    @GetMapping("student")
    public ResponseEntity<?> getAllStudent(){

        return new ResponseEntity<List<Student>>(studentService.getAllStudent(),HttpStatus.OK);

    }


    @PutMapping("student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        responseEntity = new ResponseEntity<>(student,HttpStatus.CREATED);
        return responseEntity;

    }


    @DeleteMapping("student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) throws StudentDoesnotExistsException{
        try {
            studentService.deleteStudent(id);

            responseEntity = new ResponseEntity<>("deleted", HttpStatus.OK);

        }
        catch (StudentDoesnotExistsException e){

            responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

        return responseEntity;
    }

}
