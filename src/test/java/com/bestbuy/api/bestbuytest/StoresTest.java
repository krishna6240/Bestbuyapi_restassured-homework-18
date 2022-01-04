package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.ProductPojo;
import com.bestbuy.api.StoresPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBase {
    private java.lang.Object Object;

    @Test
    public void test001() {   //getAllStoreInfo
        Response response =
                given()
                        .basePath("/stores")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {  //createNewStore
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Abcdefg");
        storesPojo.setType("Hardware");
        storesPojo.setAddress("12 AbcPlaza");
        storesPojo.setAddress2("abcde");
        storesPojo.setCity("NewTown");
        storesPojo.setState("NJ");
        storesPojo.setZip("12348");
        storesPojo.setLat(12.154f);
        storesPojo.setLng(12.235f);
        storesPojo.setHours("String");

        Response response = given()
                .basePath("/stores")
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }


    @Test
    public void test003() {  //getStoreById
        ProductPojo productPojo = new ProductPojo();

        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id", 6)
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }

    @Test
    public void test004() {  //updateRecordByPatch
        ProductPojo productPojo = new ProductPojo();
        productPojo.setType("SmallBox");


        Response response =
                given().log().all()
                        .basePath("/stores")
                        .header("Content-Type", "application/json")
                        .body(productPojo)
                        .when()
                        .patch("/6");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test005() { //deleteStoresById
        ProductPojo productPojo = new ProductPojo();
        Response response = given()
                .basePath("/stores")
                .header("Content-Type", "application/json")
                //.header("Accept", "application/json")
                .body(productPojo)
                .when()
                .delete("/4");
        response.then().statusCode(404);
        response.prettyPrint();
    }


}


