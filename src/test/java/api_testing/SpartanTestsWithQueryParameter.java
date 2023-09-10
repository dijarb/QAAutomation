package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;

public class SpartanTestsWithQueryParameter {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void QueryParam1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Female")
                .and().queryParam("nameContains", "J")
                .when().get("/api/spartans/search");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertTrue(response.body().asString().contains("Female"));
        Assert.assertFalse(response.body().asString().contains("Male"));
        Assert.assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();
    }

    @Test
    public void queryParams2(){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("gender","Female");
        paramsMap.put("nameContains", "J");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertTrue(response.body().asString().contains("Female"));
        Assert.assertFalse(response.body().asString().contains("Male"));
        Assert.assertTrue(response.body().asString().contains("Janette"));

        response.prettyPrint();
    }


}
