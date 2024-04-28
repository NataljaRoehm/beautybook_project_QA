package beautybook.API.tests.procedure;

import beautybook.API.dto.procedure.ProcedureDto;
import beautybook.API.tests.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllProcedureRATests extends TestBase {

    // Позитивный тест
    @Test
    public void getAllProceduresSuccessTest() {
        Response response = given()
                .header(AUTH, token)
                .when()
                .get("procedures");

        if (response.statusCode() == 200) {
            ProcedureDto[] procedures = response.as(ProcedureDto[].class);
            for (ProcedureDto procedure : procedures) {
                System.out.println(procedure.getId() + " *** " + procedure.getName());
                System.out.println("================");
            }
        } else {
            System.out.println("Unexpected status code: " + response.statusCode());
        }
    }
}