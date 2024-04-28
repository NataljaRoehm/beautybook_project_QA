package beautybook.API.tests.category;

import beautybook.API.dto.category.CategoryDto;
import beautybook.API.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllCategoryRATests extends TestBase {

    @Test
    public void getAllCategoriesSuccessTest() {
        Response response = given()
                .header(AUTH, token)
                .when()
                .get("categories");

        if (response.statusCode() == 200) {
            CategoryDto[] categories = response.as(CategoryDto[].class);
            for (CategoryDto category : categories) {
                System.out.println(category.getId() + " *** " + category.getName());
                System.out.println("================");
            }
        } else {
            System.out.println("Unexpected status code: " + response.statusCode());
        }
    }
}