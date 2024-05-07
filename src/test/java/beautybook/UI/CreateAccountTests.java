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
    public void registerExistedUserNegativeTest() {
//    public void registerNewUserPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().clickOnRegisterButton();
        app.getUser().fillRegisterForm(new User()
                .setLastName("Nad")
                .setFirstName("Man")
                .setEmail("nm@gm.com")
                .setPassword("Qwert!1234"));
        app.getUser().click(By.xpath("//button[.='Eine Konto erstellen']"));


        Assert.assertTrue(app.getUser().isErrorAccountPresent());


    }
}
