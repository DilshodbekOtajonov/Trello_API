package com.example.trelloApi.exceptions;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/26/22 12:16 PM (Friday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */
public class GenericNotFoundException extends RuntimeException{
    public GenericNotFoundException(String message) {
        super(message);
    }

    public GenericNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
