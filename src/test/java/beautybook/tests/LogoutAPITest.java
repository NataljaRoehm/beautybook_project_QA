package beautybook.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogoutAPITest extends TestBase{
    @Test
    public void logoutTest() {
        given()
                .header(AUTH,token)
                .when()
                .get("auth/logout")
                .then()
                .assertThat().statusCode(200);
    }
}
