package com.yoga.yoga_tracker_service.Exception;

import com.yoga.yoga_tracker_service.DTO.GlobalExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalExceptionDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        GlobalExceptionDTO globalExceptionDTO = new GlobalExceptionDTO();
        ex.getAllErrors().forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String msg = error.getDefaultMessage();
                    errors.put(fieldName, msg);
                }
        );
        globalExceptionDTO.setMessage("Validation failed");
        globalExceptionDTO.setStatusCode(ex.getStatusCode());
        globalExceptionDTO.setErrors(errors);

        return new ResponseEntity<>(globalExceptionDTO, ex.getStatusCode());
    }
}
