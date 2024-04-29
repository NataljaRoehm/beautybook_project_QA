package beautybook.API.tests;

import beautybook.API.dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserByIdRATests extends TestBase {
    @Test
    public void getUserByIdSuccessTest() {
        int targetUserId = 30;
        Response response = given()
                .header(AUTH, token)
                .when()
                .get("users/" + targetUserId)
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        UserDto user = response.as(UserDto.class);

        if (user != null) {
            System.out.println(user.getId() + " ******* " + user.getFirstName());
            System.out.println("================");
        } else {
            System.out.println("User with ID " + targetUserId + " not found.");
        }
    }
}