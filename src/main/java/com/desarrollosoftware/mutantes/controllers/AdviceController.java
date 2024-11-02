package com.desarrollosoftware.mutantes.controllers;

import com.desarrollosoftware.mutantes.models.exceptions.NotMutantException;
import com.desarrollosoftware.mutantes.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;


@ControllerAdvice
public class AdviceController {

    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleValidationExceptions(MethodArgumentNotValidException e) {

        ErrorDto error = new ErrorDto(e.getClass().getSimpleName(),
                e.getMessage(),
                LocalDateTime.now().toString());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(NotMutantException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorDto> handleNotMutantException(NotMutantException e) {

        ErrorDto error = new ErrorDto(e.getClass().getSimpleName(),
                e.getMessage(),
                LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(Exception.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception e) {

        ErrorDto error = new ErrorDto(e.getClass().getSimpleName(),
                e.getMessage(),
                LocalDateTime.now().toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}








































