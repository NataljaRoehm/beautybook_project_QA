package beautybook.API.tests.booking;

import beautybook.API.dto.booking.BookingDto;
import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

//public class CreateBookingRATests extends TestBase {
//
//    @Test
//    public void addBookingSuccessTest() {
//
//        BookingDto bookingDto = BookingDto.builder()
//                .clientId(24)
//                .masterId(1)
//                .procedureId(5)
//                .dateTime("2024-05-16T10:00:00")
//                .build();
//
//        Response response = given()
//                .header(AUTH, token)
//                .body(bookingDto)
//                .contentType(ContentType.JSON)
//                .when()
//                .post("/bookings")
//                .then()
//                //.assertThat().statusCode(201)
//                .extract().response();
//
//        int bookingId = response.jsonPath().getInt("id");
//        System.out.println("ID бронирования: " + bookingId);
//    }
//}
public class CreateBookingRATests extends TestBase {

    @Test
    public void addBookingSuccessTest() {

        BookingDto bookingDto = BookingDto.builder()
                .clientId(24)
                .masterId(1)
                .procedureId(3)
                .dateTime("2024-05-16T10:00:00")
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(bookingDto)
                .contentType(ContentType.JSON)
                .when()
                .post("/bookings")
                .then()
                //.assertThat().statusCode(201)
                .extract().response();

        String responseBody = response.getBody().asString();
        System.out.println("Ответ сервера: " + responseBody);

        Object bookingIdObject = response.jsonPath().get("id");
        int bookingId;
        if (bookingIdObject instanceof Integer) {
            bookingId = (Integer) bookingIdObject;
        } else if (bookingIdObject instanceof String) {
            bookingId = Integer.parseInt((String) bookingIdObject);
        } else {
            throw new RuntimeException("Не удалось получить ID бронирования из ответа сервера");
        }

        System.out.println("ID бронирования: " + bookingId);
    }
}