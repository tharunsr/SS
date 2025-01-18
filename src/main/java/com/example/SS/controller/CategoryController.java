package com.example.SS.controller;

import com.example.SS.entities.Category;
import com.example.SS.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryService service;

//    @GetMapping(" ")
//    public String display(){
//        return "Welcome to Category Section";
//    }

    @GetMapping("/categories")
    public List<Category> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable int id){
        return service.getCategoryById(id);
    }

//    @PostMapping("/categories")
//    public void addProduct(@RequestBody Category prod){
//        service.addProduct(prod);
//    }
//
//    @PutMapping("/categories")
//    public void update(@RequestBody Category prod){
//        service.update(prod);
//    }
//
//    @DeleteMapping("/categories/{id}")
//    public void deleteById(@PathVariable int id){
//        service.deleteById(id);
//    }


}
