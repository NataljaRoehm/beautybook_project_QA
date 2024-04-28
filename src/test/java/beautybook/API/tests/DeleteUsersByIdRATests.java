package beautybook.API.tests;

import beautybook.API.dto.NewUserDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;

//public class DeleteUsersByIdRATests extends TestBase {
//    String id;

//    @BeforeMethod
//    public void precondition() {
//        NewUserDto userDto = NewUserDto.builder()
//                .firstName("Marfa")
//                .lastName("Lobina")
//                .email("marfa@gmail.com")
//                .hashPassword("Hn2191245$")
//                .role("MASTER")
//                .build();
//
//        Response response = given()
//                .header(AUTH, token)
//                .body(userDto)
//                .contentType(ContentType.JSON)
//                .when()
//                .post("users/register")
//                .then()
//                //.assertThat().statusCode(201)
//                .extract().response();
//
//        String message = response.getBody().asString();
//
//        if (message.contains("id")) {
//            id = response.path("id").toString();
//        } else {
//            throw new RuntimeException("Не удалось получить ID пользователя из ответа сервера");
//        }
//    }

//    @BeforeMethod
//    public void precondition() {
//        NewUserDto userDto = NewUserDto.builder()
//                .firstName("Marfa")
//                .lastName("Lobina")
//                .email("marfa@gmail.com")
//                .hashPassword("Hn2191245$")
//                .role("MASTER")
//                .build();
//
//        Response response = given()
//                .header(AUTH, token)
//                .body(userDto)
//                .contentType(ContentType.JSON)
//                .when()
//                .post("users/register")
//                .then()
//                .extract().response();
//
//        id = response.jsonPath().get("id").toString();
//        if (id == null || id.isEmpty()) {
//            throw new RuntimeException("Не удалось получить ID пользователя из ответа сервера");
//        }
//    }
//    // positive test
//    @Test
//    public void deleteUserByIdSuccessTest() {
//        if (id != null) {
//            given()
//                    .header(AUTH, token)
//                    .when()
//                    .delete("users/" + id)
//                    .then()
//                    .assertThat().statusCode(200);
//        } else {
//            throw new RuntimeException("ID пользователя не был получен в предварительном шаге");
//        }
//    }
//}
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

        id = response.jsonPath().getString("id"); // Получаем значение ID в виде строки
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
                    .delete("users/" + id) // Исправленный URL-адрес для запроса DELETE
                    .then()
                    .assertThat().statusCode(200);
        } else {
            throw new RuntimeException("ID пользователя не был получен в предварительном шаге");
        }
    }
}
