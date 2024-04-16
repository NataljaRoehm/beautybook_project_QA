package beautybook.tests;

import beautybook.dto.LoginRequestDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginRATests extends TestBase{

    LoginRequestDto login = LoginRequestDto.builder()
            .email("nm@gm.com")
            .hashPassword("Qwert!1234")
            .build();

    @Test
    public void loginSuccessTest(){
        given()
                .contentType("application/json")
                .body(login)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(200);

    }

}
