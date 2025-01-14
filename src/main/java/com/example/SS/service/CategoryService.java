package com.example.SS.service;

import com.example.SS.entities.Category;
import com.example.SS.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repo;

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public void addProduct(Category prod) {
        repo.save(prod);
    }

    public void update(Category prod) {
        repo.save(prod);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
