package com.bestbuy.api.extractionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractionHomework {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then();
    }

    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total number of limit is : "+limit );
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the total
    @Test
    public void test002(){
        int total =response.extract().path("total");
        System.out.println("te total is : "+total);
    }
    //3. Extract the name of 5th store
    @Test
    public void test003(){
        String name = response.extract().path("data[4].name");
        System.out.println("Name of the store is :"+name);
    }
    //4. Extract the names of all the store
    @Test
    public void test004(){
        List <String> storeName = response.extract().path("data.name");
        System.out.println("Store name list is :"+storeName);
    }
    //5. Extract the storeId of all the store
    @Test
    public void test005(){
        List <String> storeId = response.extract().path("data.id");
        System.out.println("Store id list is :"+storeId);
    }
    //6. Print the size of the data list
    @Test
    public void test006(){
        int size = response.extract().path("data.size");
        System.out.println("The size of the data list :"+size);
    }
    //7. Get all the value of the store where store name = Moline
    @Test
    public void test007(){
        List < HashMap<String,?>> value = response.extract().path("data.findAll{it.name=='Oakdale'}");
        System.out.println("The value of store :"+value);
    }
    //8. Get the address of the store where store name = Appleton
    @Test
    public void test008(){
        List< HashMap<String,?>> address=response.extract().path("data.findAll{it.name=='Electronics Recycling'}");
        System.out.println("Address :"+address);
    }
    //9. Get all the services of 8th store
    @Test
    public void test009(){
        List < HashMap<String,?>> services = response.extract().path("data.findAll{it.name='service[7]'}");
        System.out.println("services name :"+services);
    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010(){
        List < HashMap<String,Object>> storeservices = response.extract().path("data[3].services[5].storeservices");
        System.out.println("services name :"+storeservices);

    }
    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List <String> storeId = response.extract().path("data.id");
        System.out.println("Store id list is :"+storeId);
    }
    //12. Get id of all the store
    @Test
    public void test012(){
        List <String> id = response.extract().path("data.id");
        System.out.println("Store id list is :"+id);
    }
    //13. Find the store names Where state = WI
    @Test
    public void test013(){
        List < HashMap<String,?>> state = response.extract().path("data.findAll{it.name='ND'}.name");
        System.out.println("store name :"+state);
    }
    //14. Find the Total number of services for the store where store name = Cedar Rapids
    @Test
    public void test014(){
        List < HashMap<String,?>> storeName = response.extract().path("data.findAll{it.name='Samsung Experience Shop'}");
        System.out.println("store name :"+ storeName);
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){
        List < HashMap<String,?>> serviceName = response.extract().path("data.findAll{it.name='Best Buy Mobile'}");
        System.out.println("service name :"+ serviceName);
    }
    //16. Find the name of all services Where store name = “Molin”
    @Test
    public void test016(){
       // List <String> storeName = response.extract().path("data.services.name").Hablamos Español);
        //List < HashMap<String,?>> storeName = response.extract().path("data.findAll{it.name='Roseville'}.services");
       // List <String> name = response.extract().path("data.findAll{it.name=='Roseville'}.services.name");
        List<String> services = response.extract().path("data.findAll{it.name=='Oakdale'}.services.name");
       // List<String> services = response.extract().path("data.findAll{it.name=='Oakdale'}.services.name");
        System.out.println("service name :"+ services);
    }
    //17. Find the zip of all the store
    @Test
    public void test017(){

        List < HashMap<String,?>> storeZip = response.extract().path("data.zip");
        System.out.println("Zip of all store :"+storeZip);
    }
    //18. Find the zip of store name = Minnetonka
    @Test
    public void test018(){
        List<Integer>services= response.extract().path("data.findAll{it.name=='fargo'}.zip");
        System.out.println("Zip of all store :"+services);
    }
    //19. Find the storeservices details of the service name = Samsung
    @Test
    public void test019(){
        List < HashMap<String,?>> storeName = response.extract().path("data.findAll{it.name='Samsung Experience Shop'}");
        System.out.println("service name :"+ storeName);
    }
    // 20. Find the lat of all the stores
    @Test
    public void test020(){
       List < HashMap<String,Object>> storeLat = response.extract().path("data.lat");

        System.out.println("Zip of all store :"+storeLat);
    }






    }





