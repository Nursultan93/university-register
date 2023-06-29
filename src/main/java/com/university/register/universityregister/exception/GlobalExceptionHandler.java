package com.university.register.universityregister.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ExceptionResponse> handleStudentNotFound(StudentNotFound studentNotFound, WebRequest request) {
        ExceptionResponse ex = new ExceptionResponse();
        ex.setTimestamp(LocalDateTime.now());
        ex.setMessage(studentNotFound.getMessage());
        ex.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
        ex.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }

}
