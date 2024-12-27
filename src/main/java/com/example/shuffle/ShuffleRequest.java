package com.example.shuffle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ShuffleRequest {

    @Min(1)
    @Max(1000)

    private int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ShuffleRequest{number=" + number + "}";
    }
}