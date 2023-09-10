package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.testng.*;
import org.testng.annotations.*;
import pojo.*;

import java.util.*;

public class SpartanPOSTRequests {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void PostWithString(){

        Response post = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"gender\": \"Male\",\n" +
                        "  \"name\": \"Mikkel\",\n" +
                        "  \"phone\": 46562181613\n" +
                        "}").when().post("api/spartans/");

        Assert.assertEquals(post.statusCode(),201);
        Assert.assertEquals(post.contentType(),"application/json");

        Assert.assertEquals(post.path("success"),"A Spartan is Born!");

        JsonPath json = post.jsonPath();
        Assert.assertEquals(json.getString("data.name"),"Mikkel");
        Assert.assertEquals(json.getString("data.gender"),"Male");
        Assert.assertEquals(json.getLong("data.phone"),46562181613l);
    }

    @Test
    public void PostMethodWithMap(){
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("name","MikeMap");
        requestMap.put("gender","Male");
        requestMap.put("phone",4214432546442l);

        Response post = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(requestMap)
                .when().post("api/spartans/");

        Assert.assertEquals(post.statusCode(),201);
        post.prettyPrint();
    }

    @Test
    public void POSTWithPojo(){
        Spartan spartan = new Spartan("Jonas","Male",5616816132l);

        Response post = RestAssured.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(spartan)
                .when().post("api/spartans/");

        Assert.assertEquals(post.statusCode(),201);
        post.prettyPrint();

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 204)
                .and().when().get("/api/spartans/{id}");

        Spartan spartanResponse = response.body().as(Spartan.class);

        System.out.println(spartanResponse.toString());
    }
}
