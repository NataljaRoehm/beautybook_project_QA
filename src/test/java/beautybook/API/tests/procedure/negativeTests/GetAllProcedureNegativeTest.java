package beautybook.API.tests.procedure.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProcedureNegativeTest extends TestBase {
    @Test
    public void getProceduresUnauthorizedTest() {

        Response response = RestAssured.get("procedures");

        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertTrue(response.getBody().asString().contains("User not authenticated"));
    }

    @Test
    public void getProceduresForbiddenTest() {

        Response response = given()
                .header(AUTH, token)
                .when()
                .get("procedures");

        Assert.assertEquals(response.getStatusCode(), 403);
        Assert.assertTrue(response.getBody().asString().contains("Forbidden"));
    }
}