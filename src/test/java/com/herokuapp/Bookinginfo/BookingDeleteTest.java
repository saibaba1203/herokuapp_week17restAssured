package com.herokuapp.Bookinginfo;

import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;




public class BookingDeleteTest extends TestBase {
    @Test
    public void deletUser() {
        Response response = given()

                .header("Cookie","token=2203c824ca2a002")
                .when()
                .delete("/booking/101");
        response.then().statusCode(201);
        response.prettyPrint();

    }
}




