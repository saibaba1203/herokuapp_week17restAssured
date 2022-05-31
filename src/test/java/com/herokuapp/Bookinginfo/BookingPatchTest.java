package com.herokuapp.Bookinginfo;

import com.herokuapp.model.CustomerPojo;
import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingPatchTest extends TestBase {

    @Test
    public void partialUpdateBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2018 - 01 - 01);
        bookingDatesData.put("checkout", 2019 - 01 - 01);
        customerPojo.setFirstname("James");
        customerPojo.setLastname("Brown");
        customerPojo.setTotalprice(111);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDatesData);
        customerPojo.setAdditionalneeds("Breakfast");
               Response response = given()
                       .header("Content-Type", "application/json")
                       .header("Cookie", "token=2203c824ca2a002")
                       .auth().preemptive().basic("admin", "password123")
                       .header("Accept", "application/json")
                .body(customerPojo)
                .when()
                .patch("/booking/20");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
