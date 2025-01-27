package com.example.SS.controller;


import com.example.SS.dto.CategoryDto;
import com.example.SS.entities.Category;
import com.example.SS.entities.Customer;
import com.example.SS.entities.Product;
import com.example.SS.exception.InvalidCategoryException;
import com.example.SS.service.CategoryService;
import com.example.SS.service.CustomerService;
import com.example.SS.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryService catService;

    @Autowired
    private ProductService proService;

    @Autowired
    private CustomerService custService;

//    -------------------------------CATEGORY

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@RequestBody CategoryDto catDto) {
        try {
            Category cat =  modelMapper.map(catDto,Category.class);
            catService.addCategory(cat);
            return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully!");
        } catch (InvalidCategoryException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Database or enter details");
        }
    }

    @PutMapping("/categories")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDto catDto) {
        try {
            Category cat =  modelMapper.map(catDto,Category.class);
            catService.updateCategory(cat);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Category updated successfully!");
        }
        catch (InvalidCategoryException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check Database or enter details");
        }

    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteByCategoryId(@PathVariable int id) {
        try {
            catService.deleteByCategoryId(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Category deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Caution! PK is used");
        }


    }

    //    ------------------------------- PRODUCT
    @PostMapping("/products")
    public ResponseEntity<String> addProduct(@RequestBody Product prod) {
        try {
            proService.addProduct(prod);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Is either Category id correct or present");
        }

    }

    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(@RequestBody Product prod) {
        try {
            proService.updateProduct(prod);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Is either Category id correct or present");
        }

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteByProductId(@PathVariable int id) {
        try {
            proService.deleteByProductId(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product Deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Caution! PK is used");
        }


    }
//   ----------------------------------CUSTOMER
    @GetMapping("/customers")
    public List<Customer> getAllCustomer() {
        return custService.getAllCustomer();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return custService.getCustomerById(id);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteByCustomerId(@PathVariable int id) {
        try {
            custService.deleteByCustomerId(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Customer deleted successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not exist!");
        }
    }
}
