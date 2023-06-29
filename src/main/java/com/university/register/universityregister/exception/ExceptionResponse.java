package com.university.register.universityregister.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private HttpStatus status;
    private String message;
    private String path;

}
