package com.fpis.productionsrv.controller;

import com.fpis.productionsrv.entity.Product;
import com.fpis.productionsrv.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long productId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.findById(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(productId, product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> delete(@PathVariable Long productId) {
        try {
            service.delete(productId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product newProduct) {
        Product product = service.save(newProduct);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
}
