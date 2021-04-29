package com.kinandcarta.training.springcloud;


import com.kinandcarta.training.springcloud.jpa.ProductRepository;
import com.kinandcarta.training.springcloud.model.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Optional<Product> checkProduct = productRepository.findById(product.getId());
        if (checkProduct.isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Product saveProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Product>> getAllProduct() {
        Iterable<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping(value="/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product.get());
    }


    @DeleteMapping(value="/{id}")
    public ResponseEntity removeProduct(@PathVariable("id") Long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) return ResponseEntity.notFound().build();

        productRepository.delete(product.get());
        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isEmpty()) return ResponseEntity.notFound().build();

        Product existingProduction = optionalProduct.get();
        existingProduction.setName(product.getName());
        existingProduction.setDescription(product.getDescription());
        existingProduction = productRepository.save(existingProduction);
        return ResponseEntity.ok(existingProduction);
    }


}
