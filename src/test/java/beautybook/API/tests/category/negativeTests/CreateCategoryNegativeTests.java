package beautybook.API.tests.category.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateCategoryNegativeTests extends TestBase {

    @Test
    public void testCategoryWithForbiddenStatus() {
        RestAssured.baseURI = "https://beauty-project-ki2b5.ondigitalocean.app";
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/categories")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    public void createProcedureValidationErrorTest() {

        String requestBody = "{}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("categories");

        Assert.assertEquals(response.getStatusCode(), 400, "Validation error");
    }
}
