package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.ProductPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {

    @Test
    public void getAllProductInfo(){
        Response response =
                given()
                .basePath("/products")
                .when()
                .get();
        response.then().statusCode(200);
          response.prettyPrint();
    }
    @Test
    public void creatNewProduct(){
        ProductPojo productPojo= new ProductPojo();


        productPojo.setName("Duracell - AAA Batteries (6-Pack)");
        productPojo.setType("HardGood");
        productPojo.setPrice(7.39);
        productPojo.setUpc("04125676");
        productPojo.setShipping(1);
        productPojo.setDescription("Battery");
        productPojo.setManufacturer("Duracell");
        productPojo.setModel("abc123");
        productPojo.setUrl("String");
        productPojo.setImage("String");

        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
    @Test
    public void getProductById(){
        ProductPojo productPojo= new ProductPojo();

        Response response =
                given()
                        .basePath("/products")
                        .pathParam("id",150115)
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }
    @Test
    public void updateRecordByPatch(){
        ProductPojo productPojo= new ProductPojo();
        productPojo.setPrice(8.50);


        Response response =
                given().log().all()
                        .basePath("/products")
                        .header("Content-Type","application/json")
                        .body(productPojo)
                        .when()
                        .patch("/150115");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteProductBYId(){
        ProductPojo productPojo= new ProductPojo();
        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .delete("/127687");
        response.then().statusCode(404);
        response.prettyPrint();


    }

    }






