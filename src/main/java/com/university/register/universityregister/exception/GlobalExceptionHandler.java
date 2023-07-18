package com.university.register.universityregister.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<ExceptionResponse> handleStudentNotFound(StudentNotFound studentNotFound, WebRequest request) {
        ExceptionResponse ex = new ExceptionResponse();
        ex.setTimestamp(LocalDateTime.now());
        ex.setMessage(studentNotFound.getMessage());
        ex.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
        ex.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        String message = null;

        for (ObjectError objectError : allErrors){
            message = message + ((FieldError)objectError).getField() + " : "+objectError.getDefaultMessage() +", ";
        }


        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setStatus(HttpStatus.BAD_REQUEST);
        exceptionResponse.setPath(((ServletWebRequest)request).getRequest().getRequestURI());
        exceptionResponse.setTimestamp(LocalDateTime.now());
        exceptionResponse.setMessage(message);

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
