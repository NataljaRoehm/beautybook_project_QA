package beautybook.UI;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//button[.='Get started']"))){
            driver.findElement(By.xpath("//body/div[1]/div[1]/button[1]/*[1]")).click();
        }
    }

    @Test
    public void registerNewUserPositiveTest() {
        driver.findElement(By.xpath("[button='Get started']")).click();
    }


}
