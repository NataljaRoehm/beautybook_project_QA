package beautybook.tests.category;

import beautybook.dto.category.CategoryDto;
import beautybook.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateCategoryRATests extends TestBase {

    @Test
    public void testCreateCategorySuccess() {

        CategoryDto categoryDto = CategoryDto.builder()
                .name("Maлоролоssage")
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(categoryDto)
                .contentType(ContentType.JSON)
                .when()
                .post("categories")
                .then()
                .assertThat().statusCode(201)
                .extract().response();
    }
}