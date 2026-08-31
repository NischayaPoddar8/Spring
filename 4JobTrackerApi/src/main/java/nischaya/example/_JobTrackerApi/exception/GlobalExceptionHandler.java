package nischaya.example._JobTrackerApi.exception;

import jakarta.servlet.http.HttpServletRequest;
import nischaya.example._JobTrackerApi.dto.response.ExceptionResponseDto;
import nischaya.example._JobTrackerApi.dto.response.ValidExceptionResponseDto;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Handles exceptions thrown by any restController
public class GlobalExceptionHandler {

    private final DefaultErrorAttributes errorAttributes;

    public GlobalExceptionHandler(DefaultErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidExceptionResponseDto>methodArgumentNotValidException
            (MethodArgumentNotValidException exception, HttpServletRequest request){

        Map<String,String>fieldErrors = new HashMap<>();


        exception.getBindingResult().getFieldErrors().
                forEach(
                    error->fieldErrors.put(error.getField(),error.getDefaultMessage())
                );

        ValidExceptionResponseDto dto = new ValidExceptionResponseDto(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            "Validation failed",
            request.getRequestURI(),
            fieldErrors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
}
