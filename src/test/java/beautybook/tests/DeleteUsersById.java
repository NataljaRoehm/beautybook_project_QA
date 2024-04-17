package beautybook.tests;

import beautybook.dto.MessageDto;
import beautybook.dto.UserDto;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUsersById extends TestBase {
    String id;

    @BeforeMethod
    public void precondition() {
        UserDto userDto = UserDto.builder()
                .firstName("Sweta")
                .lastName("Petja")
                .email("ts@gmail.com")
               // .description("goalkeeper")
                .role("MASTER")
                .build();

        String message = given()
                .header(AUTH, token)
                .body(userDto)
                .contentType(ContentType.JSON)
                .when()
                .post("users")
                .then()
                .assertThat().statusCode(200)
                .extract().path("message");

        String[] all = message.split(": ");
        id = all[4];
    }

    @Test
    public void deleteUserByIdSuccessTest() {
        MessageDto dto =
                given()
                        .header(AUTH, token)
                        .when()
                        .delete("users/" + id)
                        .then()
                        .assertThat().statusCode(200)
                        // .assertThat().body("message",equalTo("Contact was deleted!"));
                        .extract().response().as(MessageDto.class);
        System.out.println(dto.getMessage());
    }
}