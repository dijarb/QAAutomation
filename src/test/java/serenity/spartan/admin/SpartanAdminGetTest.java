package serenity.spartan.admin;

import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.*;

@SerenityTest
public class SpartanAdminGetTest {

    @BeforeAll
    public static void init(){
        baseURI = "http://54.236.16.200:8000";
    }

    @Test
    public void getAllSpartan(){
        given().accept(ContentType.JSON)
                .and().auth().basic("admin","admin")
                .when().get("/api/spartans")
                .then().statusCode(200).and().contentType(ContentType.JSON);
    }
}
