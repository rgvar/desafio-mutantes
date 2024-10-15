package com.desarrollosoftware.mutantes.controllers;

import com.desarrollosoftware.mutantes.dto.ErrorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AdviceController {

    private static final Logger logger = LoggerFactory.getLogger(AdviceController.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception e) {
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





}








































