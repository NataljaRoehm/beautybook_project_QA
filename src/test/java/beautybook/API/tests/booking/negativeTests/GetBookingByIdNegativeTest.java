package beautybook.API.tests.booking.negativeTests;

import beautybook.API.dto.booking.BookingDto;
import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBookingByIdNegativeTest extends TestBase {

    @Test
    public void createBookingWithValidationErrorsTest() {

        BookingDto bookingDto = BookingDto.builder()
                .clientId(30)
                .masterId(2)
                .procedureId(5)
                .status("CONFIRMED")
                .dateTime("2024-03-16T10:00:00")
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(bookingDto)
                .contentType(ContentType.JSON)
                .when()
                .post("/bookings")
                .then()
                .extract().response();

        Assert.assertThat(response.getStatusCode(), equalTo(400));
    }
}