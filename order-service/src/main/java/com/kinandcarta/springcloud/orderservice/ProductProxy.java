package com.kinandcarta.springcloud.orderservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="product-service")
public interface ProductProxy {


    @GetMapping("/product")
    public Iterable<Product> getProduct();

}
