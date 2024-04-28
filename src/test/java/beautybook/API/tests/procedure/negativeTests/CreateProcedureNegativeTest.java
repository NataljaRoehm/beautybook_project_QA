package beautybook.API.tests.procedure.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateProcedureNegativeTest extends TestBase {
    @Test
    public void createProcedureValidationErrorTest() {

        String requestBody = "{name: Manicure, price: invalid_price}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("procedures");

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertTrue(response.getBody().asString().contains("Validation error"));
    }

    @Test
    public void createProcedureUnauthorizedTest() {

        Response response = RestAssured.post("procedures");

        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertTrue(response.getBody().asString().contains("User not authenticated"));
    }

    @Test
    public void createProcedureForbiddenTest() {

        Response response = RestAssured.given()
                .header(AUTH, token)
                .when()
                .post("procedures");

        Assert.assertEquals(response.getStatusCode(), 403);
        Assert.assertTrue(response.getBody().asString().contains("Forbidden"));
    }
}