package com.github.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {


    @GetMapping
    public ResponseEntity<List<String>> list(){

        return new ResponseEntity<>(List.of("p1","p2"), HttpStatus.OK);
    }
}
