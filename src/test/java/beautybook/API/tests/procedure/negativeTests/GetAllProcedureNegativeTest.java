package beautybook.API.tests.procedure.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProcedureNegativeTest extends TestBase {
    @Test
    public void verifyProceduresEndpointForUnauthorizedStatus() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("procedurs")
                .then()
                .assertThat().statusCode(401);

    }

    @Test
    public void verifyProceduresEndpointForForbiddenStatus() {
        Response response = given()
                .contentType(ContentType.HTML)
                .when()
                .get("procedures");

        Assert.assertEquals(response.getStatusCode(), 403, "Forbidden");
    }
}