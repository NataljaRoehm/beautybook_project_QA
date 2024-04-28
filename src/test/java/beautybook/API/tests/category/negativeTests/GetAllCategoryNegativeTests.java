package beautybook.API.tests.category.negativeTests;

import beautybook.API.tests.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllCategoryNegativeTests extends TestBase {
    @Test
    public void getCategoriesUnauthorizedTest() {
        Response response = given()
                .when()
                .get("categories")
                .then()
                .extract().response();

        Assert.assertEquals(response.getStatusCode(), 401);
        Assert.assertTrue(response.getBody().asString().contains("User not authenticated"));
    }
}