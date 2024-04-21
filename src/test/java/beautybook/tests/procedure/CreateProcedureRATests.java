package beautybook.tests.procedure;

import beautybook.dto.procedure.ProcedureDto;
import beautybook.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateProcedureRATests extends TestBase {
    // Позитивный тест: создание процедуры
    @Test
    public void createProcedurePositiveTest() {

        ProcedureDto procedureDto = ProcedureDto.builder()
                .name("Mлsage")
                .price (26.0)
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(procedureDto)
                .contentType(ContentType.JSON)
                .when()
                .post("procedures")
                .then()
                .assertThat().statusCode(201)
                .extract().response();



        //@Test
        //    public void testCreateCategorySuccess() {
        //
        //        CategoryDto categoryDto = CategoryDto.builder()
        //                .name("Massage")
        //                .build();
        //
        //        Response response = given()
        //                .header(AUTH, token)
        //                .body(categoryDto)
        //                .contentType(ContentType.JSON)
        //                .when()
        //                .post("categories")
        //                .then()
        //                .assertThat().statusCode(201)
        //                .extract().response();
        //    }
        //MessageDto message = given()
        //                .header(AUTH, token)
        //                .body(contactDto)
        //                .contentType(ContentType.JSON)
        //                .when()
        //                .post("contacts")
        //                .then()
        //                .assertThat().statusCode(200)
        //                .assertThat().body("message",containsString("Contact was added!"))
        //                .extract().response().as(MessageDto.class);
        //        System.out.println(message.getMessage());
    }

}