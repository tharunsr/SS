package com.example.SS.controller;

import com.example.SS.entities.Customer;
import com.example.SS.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

//    @PostMapping("/register")
//    public void register(@RequestBody Customer customer){
//        service.register(customer);
//    }
//
//    @PostMapping("/login")
//    public String verify(@RequestBody Customer customer){
//        return service.verify(customer);
//    }
//
//    @GetMapping("/customers")
//    public List<Customer> getAll(){
//        return service.getAll() ;
//    }
//
//    @GetMapping("/customers/{id}")
//    public Customer getProductById(@PathVariable int id){
//        return service.getCustomerById(id);
//    }

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody Customer prod){
        try{
            service.addCustomer(prod);
          return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer added Successfully!");
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Product Id present on that table");
        }
    }

    @PutMapping("/customers")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer prod){
        try{
            service.update(prod);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer updated Successfully!");
        }   catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Product Id present on that table");
        }
    }

//    @DeleteMapping("/customers/{id}")
//    public void deleteById(@PathVariable int id){
//        service.deleteById(id);
//    }



}
