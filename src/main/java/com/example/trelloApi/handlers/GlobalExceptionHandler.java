package com.example.trelloApi.handlers;

import com.example.trelloApi.exceptions.GenericNotFoundException;
import com.example.trelloApi.exceptions.ValidationException;
import com.example.trelloApi.handlers.errorResponse.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author "Otajonov Dilshodbek
 * @since 8/25/22 2:32 PM (Thursday)
 * Trello_API_SPRING_BOOT/IntelliJ IDEA
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handle404(GenericNotFoundException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handle400(ValidationException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<ApiErrorResponse> handle403(IllegalAccessException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiErrorResponse> handle500(NullPointerException e, HttpServletRequest request) {
        return new ResponseEntity<>(ApiErrorResponse.builder()
                .friendlyMessage(e.getMessage())
                .developerMessage(Arrays.toString(e.getStackTrace()))
                .requestPath(request.getRequestURL().toString())
                .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
