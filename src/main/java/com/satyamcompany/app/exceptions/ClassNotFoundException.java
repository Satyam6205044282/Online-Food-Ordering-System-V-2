package com.satyamcompany.app.exceptions;

public class ClassNotFoundException extends Exception{



    public ClassNotFoundException(String message, Throwable cause) {
        super(message, cause);

    }

    public ClassNotFoundException(String message) {
        super(message);

    }

}
