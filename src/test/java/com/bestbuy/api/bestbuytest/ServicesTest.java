package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.ProductPojo;
import com.bestbuy.api.ServicesPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {
    @Test
    public void getAllServicesInfo() {
        Response response =
                given()
                        .basePath("/services")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createNewServices() {
        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("String");
        Response response = given()
                .basePath("/services")
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void getServicesById() {
        ProductPojo productPojo = new ProductPojo();

        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id", 6)
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }
    @Test
    public void updateRecordByPatch() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Abcd");


        Response response =
                given().log().all()
                        .basePath("/services")
                        .header("Content-Type", "application/json")
                        .body(productPojo)
                        .when()
                        .patch("/6");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void deleteServicesById() {
        ServicesPojo servicesPojo = new ServicesPojo();
        Response response = given()
                .basePath("/services")
                //.header("Content-Type","application/json")
                .header("Accept", "application/json")
                .body(servicesPojo)
                .when()
                .delete("/1");
        response.then().statusCode(404);
        response.prettyPrint();
    }

}