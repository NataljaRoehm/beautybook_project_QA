package beautybook.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CreateBookingTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()){
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        type(By.cssSelector("[placeholder='name@example.com']"), "lm@gm.com");
        type(By.cssSelector("[placeholder='Password']"), "Qwer!123");
        click(By.xpath("//button[contains(text(),'Login')]"));
    }

    @Test
    public void createBookingPositiveTest() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Schlossstraße 13, Bremen'])[1]/following::h2[1]"));
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Katharina Meier'])[1]/preceding::div[1]"));
        click(By.xpath("//p[@id='radix-:rr8:']/div/div/div/div[2]/div/div/div/div[2]/button[8]"));
        click(By.xpath("//p[@id='radix-:rr8:']/div/div[2]/div/div/h2[8]"));
        click(By.xpath("//div[@id='radix-:rr6:']/div[2]/div/button[2]"));

        Assert.assertTrue(isBookingCreatedById(Integer.parseInt("")));
    }

    private boolean isBookingCreatedById(int id) {
        List<WebElement> bookings = driver.findElements(By.cssSelector("h2"));
        for (WebElement element:bookings) {
            if (Boolean.parseBoolean(element.getSize().toString()))
                return true;
        }
        return false;
    }
    // @Test
//    public void removeBookingPositiveTest() {

    //}

}
