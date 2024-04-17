package beautybook.tests;

import beautybook.dto.LoginRequestDto;
import beautybook.dto.TokenResponseDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginRATests extends TestBase {

    // Positive Test
    LoginRequestDto login = LoginRequestDto.builder()
            .email("nm@gm.com")
            .hashPassword("Qwert!1234")
            .build();

    @Test
    public void loginSuccessTest() {
        TokenResponseDto dto = given()
                .contentType("application/json")
                .body(login)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(TokenResponseDto.class);
        System.out.println(dto.getAccessToken());
    }

    //Negative Tests
    LoginRequestDto loginNotValidEmail = LoginRequestDto.builder()
            .email("nmgm.com")
            .hashPassword("Qwert!1234")
            .build();

    @Test
    public void loginNotValidEmailTest() {
        given()
                .contentType("application/json")
                .body(loginNotValidEmail)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(400);
    }

    //Negative Tests
    LoginRequestDto loginNotValidPassword = LoginRequestDto.builder()
            .email("nm@gm.com")
            .hashPassword("!!!!")
            .build();

    @Test
    public void loginNotValidPasswordTest() {
        given()
                .contentType("application/json")
                .body(loginNotValidPassword)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(500);
    }
}