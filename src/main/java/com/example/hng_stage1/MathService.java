package com.example.hng_stage1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MathService {

    @Autowired
    RestTemplate restTemplate;

    public MathModel mathResponse(int number){
        boolean is_prime = isPrime(number);
        boolean is_perfect = isPerfect(number);
        List<String> properties = propertiesList(number);
        int digit_sum = digitSum(number);
        String fun_fact = getFunFact(number);
        return new MathModel(number,is_prime,is_perfect,properties,digit_sum,fun_fact);
    }

    public boolean isPrime(int number){
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPerfect(int number){
        if (number <= 0) return false;
        int sum = 1;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public boolean isArmstrong(int number){
        if (number < 0)
            return false;
        String numStr = String.valueOf(number);
        int numDigits = numStr.length();
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, numDigits);
            temp /= 10;
        }
        return sum == number;
    }

    public int digitSum(int number){
        int sum = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return sum;
    }

    public String getFunFact(int number){
        try {
            return restTemplate.getForObject("http://numbersapi.com/" + number, String.class);
        } catch (Exception e) {
            return  "No fun fact available at the moment.";
        }
    }

    public List<String> propertiesList(int number){
        List<String> props = new ArrayList<>();
        if (isArmstrong(number)&&(number%2==0)){
            props.addAll(Arrays.asList("armstrong","even"));
        } else if (isArmstrong(number)&&(number%2!=0)) {
            props.addAll(Arrays.asList("armstrong","odd"));
        } else if (!isArmstrong(number)&&(number%2==0)) {
            props.add("even");
        }
        else {
            props.add("odd");
        }
        return new ArrayList<>(props);
    }

}
