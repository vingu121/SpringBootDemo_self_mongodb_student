package com.project.demo.exception;

public class StudentAlreadyExistsException extends Exception {

    private String message;

    public StudentAlreadyExistsException(){}

    public StudentAlreadyExistsException(String message){

        super(message);
        this.message=message;

    }

}
