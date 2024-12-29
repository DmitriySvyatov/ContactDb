package com.example.contactappdb.exception;

public class ContactNotFound extends RuntimeException{
    public ContactNotFound(String message) {
        super(message);
    }
}
