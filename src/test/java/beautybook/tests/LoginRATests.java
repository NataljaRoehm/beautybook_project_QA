package beautybook.tests;

import beautybook.dto.ErrorDto;
import beautybook.dto.LoginRequestDto;
import beautybook.dto.TokenResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginRATests extends TestBase {

    // Positive Test
    LoginRequestDto login = LoginRequestDto.builder()
            .email("petja@mail.com")
            .hashPassword("Pwerty007!")
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
    @Test
    public void invalidEmailFormatTest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(LoginRequestDto.builder()
                        .email("petja@mail.")
                        .hashPassword("Pwerty007!")
                        .build())
                .when()
                .post("auth/login");

        response.then().statusCode(400);

        response.then().body("errors[0].field", equalTo("email"));
        response.then().body("errors[0].rejectedValue", equalTo("petja@mail."));
        response.then().body("errors[0].message", equalTo("Invalid email format"));
    }

    LoginRequestDto loginNotValidPassword = LoginRequestDto.builder()
            .email("petja@mail.com")
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