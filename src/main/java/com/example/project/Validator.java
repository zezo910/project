package com.example.project;

public class Validator {

    public static boolean IsOnlyLetters(String text) {

        return text.matches("^[a-zA-Z\\u0600-\\u06FF\\s]+$");
    }
    public static boolean isOnlyDigits(String text) {
        return text.matches("^[0-9]+$");
    }
    public static boolean IsNotZero(double num){
        return num!=0 ;

    }
    public  static boolean IsPositive(double num){
        return (num>0);
    }
    public static boolean IsNotZero(int num){
        return num!=0 ;

    }
    public  static boolean IsPositive(int num){
        return (num>0);
    }


}
