package com.angry.hospital.exception;

import com.angry.hospital.utils.RResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;
import javax.validation.ConstraintViolationException;
import java.time.format.DateTimeParseException;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<RResponse>  handleError1(MultipartException e) {
        return new ResponseEntity<>(new RResponse().getInstance(e.getMessage()), HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity<RResponse> customException(UsernameNotFoundException e) {
        return new ResponseEntity<>(new RResponse().getInstance(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<RResponse> customException(RuntimeException e) {
        e.printStackTrace();
        return new ResponseEntity<>(new RResponse().getInstance(e.getMessage()), HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<RResponse> runTimeException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<RResponse> unAuthorizedException(Exception ex) {
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<RResponse> unAuthorizedException(AppException ex) {
        System.out.println("exception e "+ ex.getMessage());
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()),ex.httpStatus);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<RResponse> unAuthorizedException(DateTimeParseException ex) {
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RResponse> constraintViolation(ConstraintViolationException ex) {
        return new ResponseEntity<>(new RResponse().getInstance(ex.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
