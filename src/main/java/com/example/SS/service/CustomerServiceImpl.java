package com.example.SS.service;

import com.example.SS.entities.Customer;
import com.example.SS.entities.CustomerPrinciple;
import com.example.SS.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer cust = repo.findByUsername(username);
        if(cust==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomerPrinciple(cust);
    }
}
