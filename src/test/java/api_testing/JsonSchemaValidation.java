package api_testing;

import static io.restassured.RestAssured.*;
import io.restassured.*;
import io.restassured.http.*;
import org.testng.annotations.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class JsonSchemaValidation {
    @BeforeClass
    public void setUpClass(){
        RestAssured.baseURI="http://54.236.16.200:8000";
    }

    @Test
    public void test1(){
        given().accept(ContentType.JSON)
                .pathParam("id",10).then()
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));

    }
}
