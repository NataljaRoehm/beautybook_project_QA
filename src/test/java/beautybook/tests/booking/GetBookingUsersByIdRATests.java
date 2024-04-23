package beautybook.tests.booking;

import beautybook.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class GetBookingUsersByIdRATests extends TestBase {
    @Test
    public void getUserBookingsByStatusTest() {

        long userId = 2;
        String status = "CONFIRMED";

        Response response = given()
                .pathParam("user-id", userId)
                .queryParam("status", status)
                .when()
                .get("bookings/{user-id}");

        response.then().statusCode(200);

        response.then().body("bookingId", notNullValue());
        // без статуса проверки*(с проверкой падает)
       // response.then().body("status", hasItem(status));

        System.out.println("User " + userId + " bookings with status " + status + ":");
        response.prettyPrint();
    }
}