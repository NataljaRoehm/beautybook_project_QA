package beautybook.tests;

import beautybook.dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserByIdRATests extends TestBase{
    @Test

    public void getUserByIdSuccessTest() {
        int targetUserId = 8;
        Response response = given()
                .header(AUTH, token)
                .when()
                .get("users")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        UserDto[] users = response.as(UserDto[].class);
        UserDto targetUser = null;
        for (UserDto user : users) {
            if (user.getId() == targetUserId) {
                targetUser = user;
                break;
            }
        }

        if (targetUser != null) {
            System.out.println(targetUser.getId() + " ******* " + targetUser.getFirstName());
            System.out.println("================");
        } else {
            System.out.println("User with ID " + targetUserId + " not found.");
        }
    }
}
