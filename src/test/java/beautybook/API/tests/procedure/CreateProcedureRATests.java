package beautybook.API.tests.procedure;

import beautybook.API.dto.procedure.ProcedureDto;
import beautybook.API.tests.TestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateProcedureRATests extends TestBase {
    // Позитивный тест:
    @Test
    public void createProcedurePositiveTest() {

        ProcedureDto procedureDto = ProcedureDto.builder()
                .name("Masage")
                .price (26.0)
                .build();

        Response response = given()
                .header(AUTH, token)
                .body(procedureDto)
                .contentType(ContentType.JSON)
                .when()
                .post("procedures")
                .then()
                //.assertThat().statusCode(201)
                .extract().response();
    }
}