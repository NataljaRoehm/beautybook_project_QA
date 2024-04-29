package beautybook.API.tests;

import beautybook.API.dto.NewUserDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NewUserRATests extends TestBase{
    //Positives Test
    NewUserDto userDto = NewUserDto.builder()
            .firstName("Sascha")
            .lastName("Zetrova")
            .email("sascha@gmail.com")
            .hashPassword("Sascha145$")
            .role("CLIENT")
            .build();

    @Test
    public void newUserSuccessTest(){
        given()
                .contentType("application/json")
                .body(userDto)
                .when()
                .post("users/register")
                .then()
                .assertThat().statusCode(201);
    }

    // Negatives Test NotValidFirstname
    NewUserDto userNotValidFirstname = NewUserDto.builder()
            .firstName("12as")
            .lastName("Zetrova")
            .email("sascha@gmail.com")
            .hashPassword("Sascha145$")
            .role("CLIENT")
            .build();

    @Test
    public void userNotValidFirstnameTest() {
        given()
                .contentType("application/json")
                .body(userNotValidFirstname)
                .when()
                .post("users/register")
                .then()
                .assertThat().statusCode(409);
    }

    // Negatives Test NotValidLastname
    NewUserDto userNotValidLastname = NewUserDto.builder()
            .firstName("Sascha")
            .lastName("123ja")
            .email("sascha@gmail.com")
            .hashPassword("Sascha145$")
            .role("CLIENT")
            .build();

    @Test
    public void userNotValidLastnameTest() {
        given()
                .contentType("application/json")
                .body(userNotValidLastname)
                .when()
                .post("users/register")
                .then()
                .assertThat().statusCode(404);
    }

    // Negatives Test NotValidEmail
    NewUserDto userNotValidEmail = NewUserDto.builder()
            .firstName("Sascha")
            .lastName("Zetrova")
            .email("saschagmail.com")
            .hashPassword("Sascha145$")
            .role("CLIENT")
            .build();

    @Test
    public void userNotValidEmailTest() {
        given()
                .contentType("application/json")
                .body(userNotValidEmail)
                .when()
                .post("users/register")
                .then()
                .assertThat().statusCode(404);
    }

    // Negatives Test NotValidPassword
    NewUserDto userNotValidPassword = NewUserDto.builder()
            .firstName("Sascha")
            .lastName("Zetrova")
            .email("katja@gmail.com")
            .hashPassword("H")
            .role("CLIENT")
            .build();

    @Test
    public void userNotValidPasswordTest() {
        given()
                .contentType("application/json")
                .body(userNotValidPassword)
                .when()
                .post("users/register")
                .then()
                .assertThat().statusCode(404);
    }
}