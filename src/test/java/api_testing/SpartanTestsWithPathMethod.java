package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class SpartanTestsWithPathMethod {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");

        System.out.println("id: "+response.path("id").toString());
        System.out.println("name: "+response.path("name").toString());
        System.out.println("gender: "+response.path("gender").toString());
        System.out.println("phone: "+response.path("phone").toString());

        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        Assert.assertEquals(id,10);
        Assert.assertEquals(name,"Lorenza");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,3312820936l);
    }

    @Test
    public void test2(){
        Response response = RestAssured.get("/api/spartans");

//        int firstId = response.path("id[0]");
//        System.out.println("firstId = " + firstId);
//
//        String firstNameInList = response.path("name[0]");
//        System.out.println("firstName = " + firstNameInList);
//
//        String lastNameInList = response.path("name[-1]");
//        System.out.println("firstName = " + lastNameInList);
//
//        List<String> names = response.path("name");
//        System.out.println(names);
//        System.out.println("names = " + names.size());

        List<Object> phoneNumbers = response.path("phone");
        for (Object phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }
}
