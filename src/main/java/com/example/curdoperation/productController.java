package com.example.curdoperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class productController {
    @Autowired
    private ProductService service;

    @GetMapping("/products")     //returns the product
    public List<product> list() {
        return service.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<product> get(@PathVariable Integer id) {    //print the path variable value;
        try {
            product product_details = service.get(id);
            return new ResponseEntity<product>(product_details, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add_product")
    public void add(@RequestBody product product_details) {
        service.save(product_details);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody product product_details, @PathVariable Integer id) {
        try {
            product existProduct = service.get(id);
            service.save(existProduct);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
