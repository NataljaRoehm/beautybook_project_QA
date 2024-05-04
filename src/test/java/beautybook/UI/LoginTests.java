package beautybook.UI;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm();
        clickOnLoginButton();

        Assert.assertTrue(isSignOutButtonPresent());

    }

}
