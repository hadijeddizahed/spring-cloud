package com.github.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {


    @GetMapping
    public ResponseEntity<List<String>> list(){
        return new ResponseEntity<>(List.of("order1","order2"), HttpStatus.OK);
    }
}
