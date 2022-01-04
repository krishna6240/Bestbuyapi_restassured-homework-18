package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.CategoriesPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesTest extends TestBase {

    @Test
    public void getAllCategoriesInfo(){
        Response response =
                given()
                        .basePath("/categories")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void createNewCategories() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Efg");
        categoriesPojo.setId("abc123");

        Response response = given()
                .basePath("/categories")
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    @Test
    public void deleteCategoriesBYId(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        Response response = given()
                .basePath("/categories")
                .header("Content-Type","application/json")
                .body(categoriesPojo)
                .when()
                .delete("/abcat0010000");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getCategoriesById() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        Response response =
                given()
                        .basePath("/categories")
                        .pathParam("id", "abcat0020004")
                        .when()
                        .get("/{id}");
        response.prettyPrint();
    }

    @Test
    public void updateRecordByPatch() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Patel");

        Response response =
                given().log().all()
                        .basePath("/categories")
                        .header("Content-Type", "application/json")
                        .body(categoriesPojo)
                        .when()
                        .patch("/abcat0100000");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
