package beautybook.tests;

import beautybook.dto.ErrorDto;
import beautybook.dto.LoginRequestDto;
import beautybook.dto.TokenResponseDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginRATests extends TestBase {

    // Positive Test
    LoginRequestDto login = LoginRequestDto.builder()
            .email("sweta@gmail.com")
            .hashPassword("Hh12345$")
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
//    LoginRequestDto loginNotValidEmail = LoginRequestDto.builder()
//            .email("nmgm.com")
//            .hashPassword("Qwert!1234")
//            .build();

    @Test
    public void loginNotValidEmailTest() {
       ErrorDto errorDto = given()
               .contentType(ContentType.JSON)
                //.contentType("application/json")
               .body(LoginRequestDto.builder()
                       .email("swetagmail.com")
                       .hashPassword("Hh12345$")
                       .build())
                //.body(loginNotValidEmail)
                .when()
                .post("auth/login")
                .then()
                .assertThat().statusCode(400)
               .extract().response().as(ErrorDto.class);
        System.out.println(errorDto.getErrors() + " **** " + errorDto.getMessage());
    }

    //Negative Tests
    LoginRequestDto loginNotValidPassword = LoginRequestDto.builder()
            .email("sweta@gmail.com")
            .hashPassword(" 2")
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