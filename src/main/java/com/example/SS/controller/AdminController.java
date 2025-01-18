package com.example.SS.controller;

import com.example.SS.entities.Category;
import com.example.SS.entities.Customer;
import com.example.SS.entities.Product;
import com.example.SS.service.CategoryService;
import com.example.SS.service.CustomerService;
import com.example.SS.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private CategoryService catService;

    @Autowired
    private ProductService proService;

    @Autowired
    private CustomerService custService;

//    -------------------------------CATEGORY

    @PostMapping("/categories")
    public void addCategory(@RequestBody Category cat){
        catService.addCategory(cat);
    }

    @PutMapping("/categories")
    public void updateCategory(@RequestBody Category cat){
        catService.updateCategory(cat);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteByCategoryId(@PathVariable int id){
        catService.deleteByCategoryId(id);
    }

    //    ------------------------------- PRODUCT
    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        proService.addProduct(prod);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        proService.updateProduct(prod);
    }

    @DeleteMapping("/products/{id}")
    public void deleteByProductId(@PathVariable int id){
        proService.deleteByProductId(id);
    }

    //    ------------------------------- CUSTOMER

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
        return custService.getAllCustomer() ;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return custService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteByCustomerId(@PathVariable int id){
        custService.deleteByCustomerId(id);
    }


}
