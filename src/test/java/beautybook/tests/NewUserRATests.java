package beautybook.tests;

import beautybook.dto.NewUserDto;
import beautybook.dto.RefreshRequestDto;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NewUserRATests extends TestBase{
    NewUserDto userDto = NewUserDto.builder()
            .firstName("Sweta")
            .lastName("Martin")
            .email("test@gmail.com")
            .hashPassword("Hh12345$")
            .role("Master")
            .build();

    @Test
    public void newUserSuccessTest(){
                 given()
                .contentType("application/json")
                .body(userDto)
                .when()
                .post("/api/users/register")
                .then()
                .assertThat().statusCode(201);
//                .extract().response().as(RefreshRequestDto.class);
//        System.out.println(dto.getRefreshToken());
    }
}