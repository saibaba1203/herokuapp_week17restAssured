package com.herokuapp.Bookinginfo;

import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class BookingGetTest extends TestBase {

    @Test
    public void getAllBookingInfo() {
        Response response = given()
                .when()
                .get("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .when()
                .get("/booking/23");
        response.then().statusCode(200);
        response.prettyPrint();


    }


}
