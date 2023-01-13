package com.sat.quiz.exception;

public class UserNotFound extends RuntimeException{



    public UserNotFound(String message) {
        super(message);
    }
}
