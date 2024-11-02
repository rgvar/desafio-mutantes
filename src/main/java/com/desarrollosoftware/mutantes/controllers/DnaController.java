package com.desarrollosoftware.mutantes.controllers;

import com.desarrollosoftware.mutantes.dto.DnaRequest;
import com.desarrollosoftware.mutantes.dto.DnaResponse;
import com.desarrollosoftware.mutantes.services.DnaService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@Validated
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping("/mutant")
    public ResponseEntity<DnaResponse> isMutant(@RequestBody @Valid DnaRequest dnaRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(dnaService.analyzeDna(dnaRequest));
    }

}
