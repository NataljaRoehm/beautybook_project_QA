package beautybook.API.tests.category.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateCategoryNegativeTests extends TestBase {
    @Test
    public void createCategoryWithInvalidDataTest() {
        String requestBody = "{}";
        Response response = given()
                .header(AUTH, token)
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post("categories")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertTrue(response.getBody().asString().contains("Invalid category data"));
    }
    @Test
    public void createCategoryWithForbiddenAccessTest() {
        String requestBody = "{name: Make up}";
        Response response = given()
                .body(requestBody)
                .contentType(ContentType.JSON)
                .when()
                .post("categories")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 403);
        Assert.assertTrue(response.getBody().asString().contains("Forbidden"));
    }
}