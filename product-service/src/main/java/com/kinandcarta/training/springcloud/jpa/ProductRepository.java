package com.kinandcarta.training.springcloud.jpa;

import com.kinandcarta.training.springcloud.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
