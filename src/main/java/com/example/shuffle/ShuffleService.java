package com.example.shuffle;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ShuffleService {

    public List<Integer> shuffle(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        List<Integer> numbers = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
        Collections.shuffle(numbers);
        return numbers;
    }
}

