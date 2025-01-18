package com.example.SS.controller;

import com.example.SS.entities.Product;
import com.example.SS.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cosmetics/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping(" ")
    public String display(HttpServletRequest req){
        return "Welcome to Cosmetics " + req.getSession().getId();
    }

    @GetMapping("/products")
    public List<Product> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        service.addProduct(prod);
    }

    @PutMapping("/products")
    public void update(@RequestBody Product prod){
        service.update(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }



}
