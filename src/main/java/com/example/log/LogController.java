package com.example.log;

import com.example.shuffle.ShuffleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @PostMapping
    public ResponseEntity<Void> logRequest(@RequestBody ShuffleRequest request) {
        System.out.println("Received request: " + request);
        return ResponseEntity.ok().build();
    }
}
