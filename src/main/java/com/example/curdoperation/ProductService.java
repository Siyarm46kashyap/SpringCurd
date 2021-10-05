package com.example.curdoperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    private productReposetry repo;

    public List<product> listAll() {
        return repo.findAll();
    }

    public void save(product productt) {
        repo.save(productt);
    }

    public product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
