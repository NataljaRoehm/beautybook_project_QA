package beautybook.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllUsersRATests extends TestBase{

    @Test
    public void getAllUsersSuccessTest() {
        given()
//                .header(AUTH, token)
                .when()
                .get("users")
                .then()
                .assertThat().statusCode(200);
    }

}
