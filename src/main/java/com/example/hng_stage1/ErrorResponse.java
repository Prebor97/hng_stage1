package com.example.hng_stage1;

public class ErrorResponse {
    public String number;
    public boolean error;

    public ErrorResponse(String number, boolean error) {
        this.number = number;
        this.error = error;
    }
}
