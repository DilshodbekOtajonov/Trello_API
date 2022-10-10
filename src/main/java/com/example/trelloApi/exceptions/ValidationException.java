package com.example.trelloApi.exceptions;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:51 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
