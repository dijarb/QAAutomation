package api_testing;

import com.google.gson.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.testng.*;
import org.testng.annotations.*;
import pojo.*;

import java.util.*;

public class SpartanTestsPOJODeserialization {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        Spartan spartan1 = response.body().as(Spartan.class);

        Assert.assertEquals(spartan1.getName(),"Meta");
        Assert.assertEquals(spartan1.getId(),15);
        Assert.assertEquals(spartan1.getGender(),"Female");
        Assert.assertEquals(spartan1.getPhone(),1938695106l);
    }

    @Test
    public void gsonExample(){

        Gson gson = new Gson();

        String myJsonBody = "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        Spartan spartanMeta = gson.fromJson(myJsonBody,Spartan.class);

        System.out.println(spartanMeta.toString());

        Spartan spartan = new Spartan(101,"Mike","Male",123123123l);
        String jsonbody = gson.toJson(spartan);

        System.out.println(jsonbody);

    }
    @Test
    public void listOfSpartans(){

        List<Spartan> spartanList = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200).and().contentType(ContentType.JSON)
                .extract().jsonPath().getList("",Spartan.class);

        System.out.println(spartanList.toString());

    }

}
