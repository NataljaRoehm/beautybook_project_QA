package beautybook.tests;

import beautybook.dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetUserByIdRATests extends TestBase{
    @Test
//    public void getUsersByIdSuccessTest() {
//        AllUsersDto usersDto = given()
//                .header(AUTH, token)
//                .when()
//                .get("users/3")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().as(AllUsersDto.class);
//
//        for (UserDto user : usersDto.getUsers()) {
//            assertThat(user.getId(), equalTo(3));
//            assertThat(user.getFirstName(), notNullValue());
//            System.out.println(user.getId() + " ******* " + user.getFirstName());
//            System.out.println("================");
//        }
//        for (UserDto user: usersDto.getUsers()){
//            System.out.println(user.getId() + " ******* " + user.getFirstName());
//            System.out.println("================");
//        } // NullPointerException
//    }
    public void getUserByIdSuccessTest() {
        int targetUserId = 5;
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
