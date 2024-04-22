package beautybook.tests.booking;

import beautybook.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteBookingByIdRATest extends TestBase {
    String bookingId;

    @BeforeMethod
    public void precondition() {
        // Create a booking to be deleted
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .post("/bookings")
                .then()
                .statusCode(200)
                .extract().response();

        bookingId = response.jsonPath().getString("bookingId");
    }

    @Test
    public void deleteBookingByIdSuccessTest() {
        given()
                .when()
                .delete("/bookings/" + bookingId)
                .then()
                .statusCode(200)
                .body("message", equalTo("Booking was deleted!"));
    }
}
