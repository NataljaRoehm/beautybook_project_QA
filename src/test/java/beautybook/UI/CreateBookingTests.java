//package beautybook.UI;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class CreateBookingTests extends TestBase{
//
//    WebDriver driver;
//
//    @BeforeMethod
//    public void ensurePrecondition() {
//        if (!app.getUser().isLoginLinkPresent()){
//            app.getUser().clickOnSignOutButton();
//        }
//        app.getUser().clickOnLoginLink();
//        app.getUser().fillLoginForm();
//        app.getUser().clickOnLoginButton();
//    }
//
////    @FindBy(xpath = "//h5[.='Widgets']")
////    WebElement widgets;
////
////    public SidePanel getWidgets() {
////        clickWithJS(widgets,0,300);
////        return new SidePanel(driver);
////    }
//    @Test
//    public void createBookingPositiveTest() {
//
//
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Friedrichstraße 10, Berlin'])[1]/following::h2[1]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Friedrichstraße 10, Berlin'])[1]/following::button[2]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Katharina Meier'])[1]/preceding::div[1]")).click();
//        driver.findElement(By.xpath("//p[@id='radix-:r2b:']/div/div/div/div[2]/div/div/div/div[2]/button[15]/abbr")).click();
//        driver.findElement(By.xpath("//p[@id='radix-:r2b:']/div/div[2]/div/div/h2[7]")).click();
//        driver.findElement(By.xpath("//div[@id='radix-:r29:']/div[2]/div/button[2]")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Friedrichstraße 56, Düsseldorf'])[1]/following::h2[1]")).click();
//        driver.findElement(By.xpath("//*/text()[normalize-space(.)='Sugaring']/parent::*")).click();
//        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Vanessa Schmid'])[1]/preceding::div[1]")).click();
//        driver.findElement(By.xpath("//p[@id='radix-:r5e:']/div/div/div/div[2]/div/div/div/div[2]/button[15]")).click();
//        driver.findElement(By.xpath("//p[@id='radix-:r5e:']/div/div[2]/div/div/h2[7]")).click();
//        driver.findElement(By.xpath("//div[@id='radix-:r5c:']/div[2]/div/button[2]")).click();
//
//        Assert.assertTrue(app.getUser().isAlertAppears());
//    }
//
//    // @Test
////    public void removeBookingPositiveTest() {
//
//    //}
//
//}
