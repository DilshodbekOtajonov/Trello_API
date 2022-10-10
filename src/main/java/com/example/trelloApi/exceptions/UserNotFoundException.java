package com.example.trelloApi.exceptions;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/20/22 10:53 AM (Saturday)
 * Project_Blueprint/IntelliJ IDEA
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
