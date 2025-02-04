package com.example.hng_stage1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET}, allowedHeaders = "*", maxAge = 3600)
public class MathController {

    @Autowired
    MathService mathService;

    @GetMapping("/classify-number")
    public ResponseEntity<?> classifyNumber(@RequestParam("number") String num) {
        int number;
        try {
            number = Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("alphabet", true));
        }
        return new ResponseEntity<>(mathService.mathResponse(number), HttpStatus.OK);
    }
}
