package com.project.demo.exception;

public class StudentDoesnotExistsException extends Exception {

    private String message;

    public StudentDoesnotExistsException(){}

    public StudentDoesnotExistsException(String message){

        super(message);
        this.message=message;
    }
}
