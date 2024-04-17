package beautybook.tests;

import beautybook.dto.AllUsersDto;
import beautybook.dto.UserDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersRATests extends TestBase{

    @Test
//    public void getAllUsersSuccessTest() {
//        AllUsersDto allUsersDto = given()
//                .header(AUTH, token)
//                .when()
//                .get("users")
//                .then()
//                .assertThat().statusCode(200)
//                .extract().response().as(AllUsersDto.class);
//
//        for (UserDto user: allUsersDto.getUsers()){
//            System.out.println(user.getId() + " ***** " + user.getFirstName());
//            System.out.println("================");
//        }
//    }

    public void getAllUsersSuccessTest() {
        Response response = given()
                .header(AUTH, token)
                .when()
                .get("users");

        if (response.statusCode() == 200) {
            UserDto[] users = response.as(UserDto[].class);
            for (UserDto user : users) {
                System.out.println(user.getId() + " ******* " + user.getFirstName());
                System.out.println("================");
            }
        } else {
            System.out.println("Unexpected status code: " + response.statusCode());
        }
    }
}