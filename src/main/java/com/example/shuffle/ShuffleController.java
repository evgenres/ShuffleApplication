package com.example.shuffle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/shuffle")
public class ShuffleController {

    @Value("${shuffle.default-number:10}")
    private int defaultNumber;

    private final ShuffleService shuffleService;
    private final RestTemplate restTemplate;

    @Value("${service.log.url}")
    private String serviceLogUrl;

    public ShuffleController(ShuffleService shuffleService, RestTemplate restTemplate) {
        this.shuffleService = shuffleService;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<List<Integer>> shuffleNumbers(@RequestBody @Valid ShuffleRequest request) {
        if (request.getNumber() == 0) {
            request.setNumber(defaultNumber);
        }
        List<Integer> shuffledNumbers = shuffleService.shuffle(request.getNumber());

        // Asynchronously send a request to service-log
        CompletableFuture.runAsync(() -> {
            try {
                restTemplate.postForEntity(serviceLogUrl + "/log", request, Void.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return ResponseEntity.ok(shuffledNumbers);
    }
}
