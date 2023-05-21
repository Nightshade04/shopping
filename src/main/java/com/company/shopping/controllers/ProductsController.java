package com.company.shopping.controllers;

import com.company.shopping.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody String input){

        try{
            String userResponse = productsService.createProduct(input);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
