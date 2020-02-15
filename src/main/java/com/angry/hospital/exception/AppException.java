package com.angry.hospital.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException {

    public HttpStatus httpStatus;

    public AppException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
