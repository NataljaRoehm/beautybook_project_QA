package beautybook.API.tests.booking.negativeTests;

import beautybook.API.dto.booking.BookingDto;
import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateBookingNegativeTests extends TestBase {
    @Test
    public void invalidEmailFormatTest() {
        BookingDto bookingDto = BookingDto.builder()
                .clientId(1)
                .masterId(1)
                .procedureId(0)
                .status("CONFIRMED")
                .dateTime("2024-03-16T10:00:00")
                .build();

        bookingDto.setEmail("john.doe@example");

        given()
                .header(AUTH, token)
                .body(bookingDto)
                .contentType(ContentType.JSON)
                .when()
                .post("bookings")
                .then()
                .statusCode(400)
                .body("errors[0].field", equalTo("email"))
                .body("errors[0].rejectedValue", equalTo("john.doe@example"))
                .body("errors[0].message", equalTo("Invalid email format"));
    }
}