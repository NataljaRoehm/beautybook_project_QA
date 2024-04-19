package beautybook.tests.procedure;

import beautybook.dto.MessageDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static beautybook.tests.TestBase.AUTH;
import static beautybook.tests.TestBase.token;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class GetAllProcedureRATests {

    // Позитивный тест
    @Test
    public void getAllProceduresTest() {
        MessageDto messageDto = given()
                .header(AUTH, token)
                .when()
                .get("procedures")
                .then()
                .assertThat().statusCode(200)
                .extract().as(MessageDto.class);

        System.out.println("Message: " + messageDto.getMessage());
    }

    // Негативный тест
    @Test
    public void unauthorizedAccessTest() {
        Response response401 = given()
                .header(AUTH, token)
                .when()
                .get("procedures");

        response401.then()
                .assertThat().statusCode(401)
                .and().contentType(ContentType.JSON)
                .and().body("message", equalTo("User not authenticated"));

        System.out.println("Unauthorized message: " + response401.getBody().asString());
    }

    // Негативный тест
    @Test
    public void forbiddenAccessTest() {
        Response response403 = given()
                .header(AUTH, token)
                .when()
                .get("procedures");

        response403.then()
                .assertThat().statusCode(404)
                .and().contentType(ContentType.JSON)
                .and().body("message", equalTo("Forbidden"));

        System.out.println("Forbidden message: " + response403.getBody().asString());
    }
}
