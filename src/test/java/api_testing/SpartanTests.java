package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.testng.*;
import org.testng.annotations.*;

public class SpartanTests {

    String spartanBaseUrl = "http://54.236.16.200:8000";

    @Test
    public void viewSpartanTest1(){
        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

        System.out.println(response.statusCode());
        System.out.println(response.body().prettyPrint());
    }
    @Test
    public void viewSpartanTest2(){
        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");

            Assert.assertEquals(response.statusCode(),200);

            Assert.assertTrue(response.body().asString().contains("Allen"));
    }

    @Test
    public void viewSpartanTest3(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl + "/api/spartans");

        Assert.assertEquals(response.getStatusCode(),200);

        Assert.assertEquals(response.contentType(),"application/json");
    }

}
