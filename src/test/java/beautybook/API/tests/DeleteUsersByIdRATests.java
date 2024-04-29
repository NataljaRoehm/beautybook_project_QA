package beautybook.API.tests;

import beautybook.API.dto.NewUserDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUsersByIdRATests extends TestBase {
    String id;

    @BeforeMethod
    public void precondition() {
        NewUserDto userDto = NewUserDto.builder()
                .firstName("Marfa")
                .lastName("Lobina")
                .email("marfa@gmail.com")
                .hashPassword("Hn2191245$")
                .role("CLIENT")
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(userDto)
                .contentType(ContentType.JSON)
                .when()
                .post("users/register")
                .then()
                .extract().response();

        id = response.jsonPath().getString("id");
        if (id == null || id.isEmpty()) {
            throw new RuntimeException("Не удалось получить ID пользователя из ответа сервера");
        }
    }

    // positive test
    @Test
    public void deleteUserByIdSuccessTest() {
        if (id != null) {
            given()
                    .header(AUTH, token)
                    .when()
                    .delete("users/" + id)
                    .then()
                    .assertThat().statusCode(200);
        } else {
            throw new RuntimeException("ID пользователя не был получен");
        }
    }
}