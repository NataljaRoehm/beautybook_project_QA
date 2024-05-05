package beautybook.UI;

import beautybook.UI.pages.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
//    public void registerExistedUserNegativeTest() {
    public void registerNewUserPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegisterButton();
        app.getUser().fillRegisterForm(new User()
                .setLastName("Mont")
                .setFirstName("Lord")
                .setEmail("md@gm.ru")
                .setPassword("Qwer!123"));
        app.getUser().click(By.xpath("//button[contains(text(),'Eine Konto erstellen')]"));

//        Assert.assertTrue(app.getUser().isAlertAppears());

       // "Error while created account"
    }
}
