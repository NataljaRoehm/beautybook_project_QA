package beautybook.API.tests.procedure.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
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
                .assertThat().statusCode(403);
    }
}