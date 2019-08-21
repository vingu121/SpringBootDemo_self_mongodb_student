package com.project.demo.service;

import com.project.demo.domain.Student;
import com.project.demo.exception.StudentAlreadyExistsException;
import com.project.demo.exception.StudentDoesnotExistsException;
import com.project.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public Student saveStudent(Student student) throws StudentAlreadyExistsException {

        if(studentRepository.existsById(Integer.toString(student.getId()))){
            throw new StudentAlreadyExistsException("Student Already exists");
        }
        Student savedStudent= studentRepository.save(student);
        return savedStudent;
    }

    @Override
    public List<Student> getAllStudent(){
       return studentRepository.findAll();

    }

    @Override
    public Student updateStudent(Student student){

        student.setName(student.getName());
        student.setId(student.getId());
        student.setGender(student.getGender());
        return student;
    }

    @Override
    public Student deleteStudent(int id) throws StudentDoesnotExistsException{

        Student deletedStudent;
        Student student =  new Student();
//        student= studentRepository.save(student);
        if(studentRepository.existsById(Integer.toString(student.getId()))){
              studentRepository.deleteById(Integer.toString(id));

        }
        else
        {
            throw new StudentDoesnotExistsException("Student does not exists");
        }
         return deleteStudent(id);

    }
}
