package com.herokuapp.Bookinginfo;

import com.herokuapp.model.CustomerPojo;
import com.herokuapp.model.LoginPojo;
import com.herokuapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class BookingPostTest extends TestBase {

    @Test
    public void createToken() {
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setUsername("admin");
        loginPojo.setPassword("password123");
        Response response = given()
                .header("Content-Type", "application/json")
                //  .contentType(ContentType.JSON)

                .body(loginPojo)
                .when()
                .post("/auth");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void createBooking() {
        CustomerPojo customerPojo = new CustomerPojo();
        HashMap<Object, Object> bookingDatesData = new HashMap<>();
        bookingDatesData.put("checkin", 2018 - 01 - 01);
        bookingDatesData.put("checkout", 2019 - 01 - 01);
        customerPojo.setFirstname("Jim");
        customerPojo.setLastname("Brown");
        customerPojo.setTotalprice(111);
        customerPojo.setDepositpaid(true);
        customerPojo.setBookingdates(bookingDatesData);
        customerPojo.setAdditionalneeds("Breakfast");
        Response response = given()
                .header("Content-Type", "application/json")
                .header("cookie", "token=2203c824ca2a002")
                .body(customerPojo)
                .when()
                .post("/booking");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateBooking() {
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
                .auth().preemptive().basic("admin", "password123")
                .header("Accept", "application/json")
                .body(customerPojo)
                .when()
                .put("/booking/2922");
        response.prettyPrint();

    }

}
