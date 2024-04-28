package beautybook.API.tests.booking.negativeTests;

import beautybook.API.tests.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookingByIdNegative extends TestBase {

    @Test
    public void deleteBookingWithoutAuthorizationTest() {
        int bookingId = 3;

        given()
                .when()
                .delete("bookings/" + bookingId)
                .then()
                .statusCode(401)
                .body("message", equalTo("User is not authorized"));
    }

    @Test
    public void deleteBookingWithForbiddenAccessTest() {
        int bookingId = 3;

                given()
                .header(AUTH, "Bearer your_access_token_here")
                .when()
                .delete("bookings/" + bookingId)
                .then()
                .statusCode(403)
                .body("message", equalTo("Forbidden"));    }
}