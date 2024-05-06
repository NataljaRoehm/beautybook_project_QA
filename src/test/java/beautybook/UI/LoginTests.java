package beautybook.UI;

import beautybook.UI.pages.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm();
        app.getUser().clickOnLoginButton();

    }
}
