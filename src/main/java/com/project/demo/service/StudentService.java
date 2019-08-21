package com.project.demo.service;

import com.project.demo.domain.Student;
import com.project.demo.exception.StudentAlreadyExistsException;
import com.project.demo.exception.StudentDoesnotExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public Student saveStudent(Student student) throws StudentAlreadyExistsException;

    public List<Student> getAllStudent();

    public Student updateStudent(Student student);

    public Student deleteStudent(int id) throws StudentDoesnotExistsException;
}
