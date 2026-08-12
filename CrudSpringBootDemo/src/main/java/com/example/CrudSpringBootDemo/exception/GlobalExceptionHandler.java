package com.example.CrudSpringBootDemo.exception;

import com.example.CrudSpringBootDemo.Dto.ExceptionResponseDto;
import com.example.CrudSpringBootDemo.Dto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Helper class
public class GlobalExceptionHandler{

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto>handleDuplicateResourceException
            (DuplicateResourceException ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResp = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(), // status code
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // code 409
                .body(exceptionResp);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto>handleResourceNotFoundException
            (ResourceNotFoundException ex, HttpServletRequest request){
        ExceptionResponseDto exceptionResp = new ExceptionResponseDto(
                    LocalDateTime.now(),
                    HttpStatus.NOT_FOUND.value(), // status code
                    HttpStatus.NOT_FOUND.getReasonPhrase(),
                    ex.getMessage(),
                    request.getRequestURI()
                );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND) // code 404
                .body(exceptionResp); // The exception response we have built would be shown
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto>handleRuntimeException
            (RuntimeException ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResp = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // status code
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR) // code 500
                .body(exceptionResp);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto>handleGenericException
            (Exception ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResp = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // status code
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResp);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto>handleMethodArgumentNotValidException
            (MethodArgumentNotValidException ex,HttpServletRequest request) {

        Map<String,String>fieldErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach( error ->
                    fieldErrors.put(error.getField(),error.getDefaultMessage()) // Made map of
                );

        ValidationExceptionResponseDto exceptionResp = new ValidationExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), // status code
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation failed",
                request.getRequestURI(), // For path
                fieldErrors
        );
        return ResponseEntity
                .status(HttpStatus.CONFLICT) // code 409
                .body(exceptionResp);
    }
}
