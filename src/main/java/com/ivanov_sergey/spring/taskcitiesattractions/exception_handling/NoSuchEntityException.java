package com.ivanov_sergey.spring.taskcitiesattractions.exception_handling;

public class NoSuchEntityException extends RuntimeException{

    public NoSuchEntityException(String message) {
        super(message);
    }
}
