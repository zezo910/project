package com.example.project;

public class InsufficientStockException extends Exception{
    InsufficientStockException(String message){
        super(message);
    }
}
