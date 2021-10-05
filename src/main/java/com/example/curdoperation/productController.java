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
            product productt = service.get(id);
            return new ResponseEntity<product>(productt, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<product>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public void add(@RequestBody product productt) {
        service.save(productt);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody product productt, @PathVariable Integer id) {
        try {
            product existProduct = service.get(id);
            service.save(productt);
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
