package beautybook.API.tests.booking;

import beautybook.API.dto.booking.BookingDto;
import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingByIdRATest extends TestBase {
    String bookingId;

    @BeforeMethod
    public void precondition() {
        BookingDto bookingDto = BookingDto.builder()
                .clientId(6)
                .masterId(11)
                .procedureId(6)
                .dateTime("2024-05-16T10:00:00")
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(bookingDto)
                .contentType(ContentType.JSON)
                .when()
                .post("/bookings")
                .then()
                .assertThat().statusCode(201)
                .extract().response();

        bookingId = response.jsonPath().getString("id");
    }
    @Test
    public void deleteBookingByIdSuccessTest() {
        given()
                .when()
                .delete("/bookings/" + bookingId)
                .then()
                .statusCode(200);
    }
}