package nischaya.example._JobTrackerApi.exception;

import jakarta.servlet.http.HttpServletRequest;
import nischaya.example._JobTrackerApi.dto.response.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice // Handles exceptions thrown by any restController
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto>resourceNotFoundException
            (ResourceNotFoundException exception, HttpServletRequest servletRequest) {

        ExceptionResponseDto dto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                servletRequest.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto); // This response is returned on exception
    }
}
