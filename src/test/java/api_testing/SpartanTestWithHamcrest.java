package api_testing;

import io.restassured.*;
import io.restassured.http.*;
import org.hamcrest.*;
import org.testng.annotations.*;

public class SpartanTestWithHamcrest {

    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void test1(){
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().statusCode(200).and()
                .assertThat().contentType("application/json");
    }

    @Test void test2(){
        RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat()
                .body("id", Matchers.equalTo(15),"name",Matchers.equalTo("Meta"),
                        "gender",Matchers.equalTo("Female"),"phone",Matchers.equalTo(1938695106));

    }
}
