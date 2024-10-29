package com.desarrollosoftware.mutantes.controllers;


import com.desarrollosoftware.mutantes.dto.StatsResponse;
import com.desarrollosoftware.mutantes.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    public StatsService statsService;

    @GetMapping
    public ResponseEntity<StatsResponse> getStats() {

        return ResponseEntity.ok(statsService.getStats());
    }

}
