package com.kinandcarta.training.springcloud.product;

import com.kinandcarta.training.springcloud.model.Product;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.hamcrest.Matchers.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void  initialiseRestAssuredMockMvcStandalone() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    @Order(1)
    public void whenRequestPost_thenCreated(){
        with().body(new Product(2L, "TEST","TEST DESCRIPTION")).contentType(ContentType.JSON).
        when().request("POST", "/product").then().statusCode(201);
    }

    @Test
    @Order(2)
    public void whenDeleteRemoveObject(){
        when().request("DELETE", "/product/2").then().statusCode(200);
    }

    @Test
    @Order(3)
    public void testCreateModeProducts(){
        with().body(new Product(2L, "TEST","TEST DESCRIPTION")).contentType(ContentType.JSON).
                when().request("POST", "/product").then().statusCode(201);
        with().body(new Product(3L, "TEST 3","TEST DESCRIPTION")).contentType(ContentType.JSON).
                when().request("POST", "/product").then().statusCode(201);
        with().body(new Product(4L, "TEST 4","TEST DESCRIPTION")).contentType(ContentType.JSON).
                when().request("POST", "/product").then().statusCode(201);
    }

    @Test
    @Order(4)
    public void testGetAllProducts(){
        when().request("GET","/product").then().assertThat().body("name",hasItems("TEST","TEST 3","TEST 4"));
    }


    @Test
    @Order(5)
    public void testUpdateProduct(){
        with().body(new Product(2L, "Test Update","Test Update")).contentType(ContentType.JSON).
                when().request("PUT", "/product").then().statusCode(200);

        when().request("GET","/product/2").then().assertThat().body("name",equalTo("Test Update"));
    }



}
