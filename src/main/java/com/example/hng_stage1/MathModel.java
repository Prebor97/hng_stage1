package com.example.hng_stage1;

import java.util.List;

public class MathModel {
    public int number;
    public boolean is_prime;
    public boolean is_perfect;
    public List<String> properties;
    public int digit_sum;
    public String fun_fact;

    public MathModel(int number, boolean is_prime, boolean is_perfect, List<String> properties, int digit_sum, String fun_fact){
        this.number = number;
        this.is_prime = is_prime;
        this.is_perfect = is_perfect;
        this.properties = properties;
        this.digit_sum = digit_sum;
        this.fun_fact = fun_fact;
    }
}
