package com.kinandcarta.springcloud.orderservice;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class Product {


    @Getter
    @Setter
    private Long id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String description;


}
