package com.example.project;

public class DuplicateProductException extends Exception{
    DuplicateProductException(String message){
        super(message);
    }
}
