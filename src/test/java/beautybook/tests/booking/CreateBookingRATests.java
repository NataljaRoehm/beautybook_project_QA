package beautybook.tests.booking;

import beautybook.dto.booking.BookingDto;
import beautybook.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingRATests extends TestBase {

    @Test
    public void addBookingSuccessTest() {

        BookingDto bookingDto = BookingDto.builder()
                .clientId(8)
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

        int bookingId = response.jsonPath().getInt("id");
        System.out.println("ID бронирования: " + bookingId);
    }
}