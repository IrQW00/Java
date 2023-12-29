package org.example.app.exceptions;

public class IncorrectRegExException extends Exception{

    private final String message;

    public IncorrectRegExException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
