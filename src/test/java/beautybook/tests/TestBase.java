package beautybook.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public static final String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0c0BnbWFpbC5jb20iLCJleHAiOjE3MTMzODM3NDgsInVzZXJfaWQiOjQsInJvbGVzIjoiTUFTVEVSIiwiZmlyc3ROYW1lIjoiU3dldGEiLCJsYXN0TmFtZSI6IlBldGphIiwiZW1haWwiOiJ0c0BnbWFpbC5jb20ifQ.i4aPVGf1uaV5ITiAHFv__DLaNs8sviiCXLtSF_EcZCw";

    @BeforeMethod
    public void init() {

        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "api";

    }
}
