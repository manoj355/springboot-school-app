package com.example.school.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(studentNotFoundException.class)
    public ResponseEntity<ErrorException> handleGenericExpertion(Exception es,WebRequest wb)
    {
        ErrorException errorException=new ErrorException(LocalDateTime.now(),HttpStatus.INTERNAL_SERVER_ERROR.value()
    ,es.getMessage(), wb.getDescription(false));
    return new ResponseEntity<>(errorException,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidException(MethodArgumentNotValidException ex)
    {
        String message=ex.getBindingResult()
                          .getFieldErrors()
                          .stream()
                          .map(error ->error.getDefaultMessage())
                          .findFirst()
                          .orElse("ValidationError");
        Map<String, String> response = new HashMap<>();
        response.put("error", message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()
      .getFieldErrors()
      .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
}

}
