package com.example.SS.controller;

import com.example.SS.dto.CustomerDto;
import com.example.SS.entities.Customer;
import com.example.SS.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/customers")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDto prod){
        try{
            Customer customer = modelMapper.map(prod,Customer.class);
            service.addCustomer(customer);
          return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer added Successfully!");
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Product Id present on that table");
        }
    }

    @PutMapping("/customers")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDto prod){
        try{
            Customer customer = modelMapper.map(prod,Customer.class);
            service.update(customer);
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
