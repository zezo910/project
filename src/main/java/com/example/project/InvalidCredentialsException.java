package com.example.project;

public class InvalidCredentialsException extends Exception{
    InvalidCredentialsException(String message){
        super(message);
    }
}
