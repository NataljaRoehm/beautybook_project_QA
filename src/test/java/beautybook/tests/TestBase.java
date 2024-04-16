package beautybook.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void init(){
        RestAssured.baseURI="http://localhost:8080";
        RestAssured.basePath = "api";

    }
}
