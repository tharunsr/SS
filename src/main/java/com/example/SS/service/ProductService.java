package com.example.SS.service;

import com.example.SS.entities.Product;
import com.example.SS.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void update(Product prod) {
        repo.save(prod);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
