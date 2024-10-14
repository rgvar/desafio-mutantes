package com.desarrollosoftware.mutantes.controllers;

import com.desarrollosoftware.mutantes.dto.DnaRequest;
import com.desarrollosoftware.mutantes.dto.DnaResponse;
import com.desarrollosoftware.mutantes.models.Dna;
import com.desarrollosoftware.mutantes.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mutant")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping("")
    public ResponseEntity<DnaResponse> isMutant(@RequestBody DnaRequest dnaRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(dnaService.analyzeDna(dnaRequest));

    }

    @PostMapping("/multiple-mutant")
    public ResponseEntity<List<DnaResponse>> isMutantMultiple(@RequestBody List<DnaRequest> dnaList) {

        return ResponseEntity.status(HttpStatus.OK).body(dnaService.analyzeDna(dnaList));

    }

    @GetMapping("")
    public ResponseEntity<?> getAllDna() {

        return ResponseEntity.status(HttpStatus.OK).body(dnaService.getAll());

    }

}
