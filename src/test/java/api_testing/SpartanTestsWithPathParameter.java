package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SpartanTestsWithPathParameter {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void PathTest1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("api/spartans/{id}");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();
    }

    @Test
    public void negativePathParamTest(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 500)
                .when().get("/api/spartans/{id}");

        Assert.assertEquals(response.statusCode(),404);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertTrue(response.body().asString().contains("Not Found"));

    }

}
