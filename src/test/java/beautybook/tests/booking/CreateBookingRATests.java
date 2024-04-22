package beautybook.tests.booking;

import beautybook.dto.booking.BookingDto;
import beautybook.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class CreateBookingRATests extends TestBase {

    @Test
    public void addBookingSuccessTest() {
        // Создаем объект BookingDto с необходимыми полями
        BookingDto bookingDto = BookingDto.builder()
                .clientId(1)
                .masterId(1)
                .procedureId(0)
                .dateTime("2024-03-16T10:00:00")
                .build();

        // Отправляем POST-запрос для создания бронирования
        Response response = given()
                .header(AUTH, token)
                .body(bookingDto)
                .contentType(ContentType.JSON)
                .when()
                .post("/bookings")
                .then()
                .assertThat().statusCode(201) // Проверяем успешность создания бронирования
                .assertThat().body("message", containsString("Booking was successfully created"))
                .extract().response();

        // Если нужно, извлекаем ID созданного бронирования из ответа
        int bookingId = response.jsonPath().getInt("id");
        System.out.println("ID бронирования: " + bookingId);
    }
}