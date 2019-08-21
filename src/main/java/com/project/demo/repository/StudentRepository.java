package com.project.demo.repository;

import com.project.demo.domain.Student;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student,String> {



}
