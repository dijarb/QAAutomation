package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.*;

public class SpartanTestsWithJsonPath {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        int id = response.path("id");
        System.out.println("id = " + id);

        JsonPath json = response.jsonPath();

        int id1 = json.getInt("id");
        String name = json.getString("name");
        String gender = json.getString("gender");
        long phone = json.getLong("phone");

        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        Assert.assertEquals(id,11);
        Assert.assertEquals(name,"Nona");
        Assert.assertEquals(gender,"Female");
        Assert.assertEquals(phone,7959094216l);
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
