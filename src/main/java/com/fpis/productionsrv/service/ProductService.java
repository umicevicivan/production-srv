package com.fpis.productionsrv.service;

import com.fpis.productionsrv.entity.Product;
import com.fpis.productionsrv.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(Long productId) {
        return repository.findById(productId);
    }

    public Product save(Product newProduct) {
        return repository.save(newProduct);
    }

    public Product update(Long productId, Product product) {
        Product productToUpdate = repository.getOne(productId);
        productToUpdate.setName(product.getName());
        productToUpdate.setProfessionalName(product.getProfessionalName());
        productToUpdate.setShape(product.getShape());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setInstruction(product.getInstruction());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setUnitOfMeasure(product.getUnitOfMeasure());
        return repository.save(productToUpdate);
    }

    public void delete(Long id) throws Exception {
        if (Objects.isNull(id)) {
            throw new Exception("ID must not be null");
        } else {
            Product existingEntity = this.repository.findById(id).orElseThrow(() -> new Exception("Object with '" + id + "' not found"));
            repository.delete(existingEntity);
        }
    }


}
