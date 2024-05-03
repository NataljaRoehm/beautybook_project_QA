package beautybook.UI;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {
        clickOnLoginLink();
        clickOnRegisterButton();
        fillRegisterForm("lm@gm.com", "Qwer!123", "Mond", "Lora");

        click(By.xpath("//button[contains(text(),'Eine Konto erstellen')]"));
        Assert.assertTrue(isAlertAppears());

    }

}
