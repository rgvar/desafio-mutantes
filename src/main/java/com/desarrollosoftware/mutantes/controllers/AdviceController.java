package com.desarrollosoftware.mutantes.controllers;

import com.desarrollosoftware.mutantes.models.exceptions.NotMutantException;
import com.desarrollosoftware.mutantes.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


import java.time.LocalDateTime;


@ControllerAdvice
public class AdviceController {

    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);


    @ExceptionHandler(value = NotMutantException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorDto> handleNotMutantException(Exception e) {
        String errorDate = LocalDateTime.now().toString();
        String errorMsg = e.getClass() + " : " + e.getMessage() + " : " + errorDate;
        logger.error(errorMsg);

        ErrorDto error = ErrorDto.builder()
                .errorClass(e.getClass().getSimpleName())
                .errorMsg(e.getMessage())
                .errorDate(errorDate)
                .build();

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }

    @ExceptionHandler(value = Exception.class )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception e) {
        String errorDate = LocalDateTime.now().toString();
        String errorMsg = e.getClass() + " : " + e.getMessage() + " : " + errorDate;
        logger.error(errorMsg);

        ErrorDto error = ErrorDto.builder()
                .errorClass(e.getClass().getSimpleName())
                .errorMsg(e.getMessage())
                .errorDate(errorDate)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }






}








































