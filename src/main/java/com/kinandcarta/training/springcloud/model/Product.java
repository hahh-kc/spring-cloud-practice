package com.kinandcarta.training.springcloud.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
@AllArgsConstructor
public class Product {



    @Getter
    @Setter
    @Id
    @JsonProperty
    private Long id;
    @Setter
    @Getter
    @JsonProperty
    private String name;
    @Setter
    @Getter
    @JsonProperty
    private String description;

    public Product() {

    }
}
