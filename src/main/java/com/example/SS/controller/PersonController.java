package com.example.SS.controller;

import com.example.SS.entities.Customer;
import com.example.SS.entities.Person;
import com.example.SS.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping("/register")
    public void register(@RequestBody Person person){
        service.register(person);
    }

    @PostMapping("/login")
    public String verify(@RequestBody Person person){
        return service.verify(person);
    }



}
