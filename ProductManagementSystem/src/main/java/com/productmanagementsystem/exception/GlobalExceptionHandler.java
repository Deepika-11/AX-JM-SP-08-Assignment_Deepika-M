package com.productmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidProductIdException.class, InvalidUserIdException.class})
    public ResponseEntity<ErrorResponse> handleExceptionIdNotFound() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorResponse("The given name is not present");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IdAlreadyExistsException.class, UserNameAlreadyExists.class})
    public ResponseEntity<ErrorResponse> handleExceptionIdAlreadyFound() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode("404");
        errorResponse.setErrorResponse("The given name is already present");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
