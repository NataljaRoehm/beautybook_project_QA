package beautybook.tests.procedure;

import beautybook.dto.procedure.ProcedureDto;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreateProcedureRATests {
    // Позитивный тест: создание процедуры
    @Test
    public void createProcedurePositiveTest() {
        // Создаем объект процедуры
        ProcedureDto procedureDto = ProcedureDto.builder()
                .name("Manicure")
                .build();
        // Отправляем POST запрос на создание процедуры и проверяем, что код ответа 201 (успешное создание)
        given()
                .contentType(ContentType.JSON)
                .body(procedureDto)
                .when()
                .post("procedures")
                .then()
                //.assertThat().statusCode(200)
                .body("name", equalTo(procedureDto.getName()));
        //Procedure created successfully 201
        //@Test
        //    public void addContactSuccessTest() {
        //        ContactDto contactDto = ContactDto.builder()
        //                .name("Oliver")
        //                .lastName("Kan")
        //                .email("kan@gm.com")
        //                .phone("1234567890")
        //                .address("Berlin")
        //                .description("goalkeeper")
        //                .build();
        //
        //        MessageDto message = given()
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