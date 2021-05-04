package com.kinandcarta.springcloud.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderServiceController {

    @Autowired
    private ProductProxy productProxy;

    @GetMapping("/order/product")
    public Iterable<Product> getProducts() {
        return productProxy.getProduct();
    }
}
