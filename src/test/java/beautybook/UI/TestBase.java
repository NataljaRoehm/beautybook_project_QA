package beautybook.UI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://beaty-project-2-0-dwyu.vercel.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void type(By locator, String text) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.alertIsPresent());
        if (alert==null) {
            return false;
        }else {
            return true;
        }
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//body/div[1]/div[1]/button[1]/*[1]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/sign-in']"));
    }

    public void clickOnRegisterButton() {
        click(By.linkText("-Klicken Sie hier, um sich registriren"));
    }

    public void fillRegisterForm(String email, String password, String lastName, String firstName) {
        type(By.cssSelector("[placeholder='First Name']"), firstName);
        type(By.cssSelector("[placeholder='Last Name']"), lastName);
        type(By.cssSelector("[placeholder='name@example.com']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/sign-in']"));
    }

    public void fillLoginForm() {
        type(By.cssSelector("[placeholder='name@example.com']"), "lm@gm.com");
        type(By.cssSelector("[placeholder='Password']"), "Qwer!123");
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(text(),'Login')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//body/div[1]/div[1]/button[1]/*[1]"));
    }
}
