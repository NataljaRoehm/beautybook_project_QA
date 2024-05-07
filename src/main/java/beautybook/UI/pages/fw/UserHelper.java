package beautybook.UI.pages.fw;

import beautybook.UI.pages.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
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

    public void fillRegisterForm(User user) {
        type(By.cssSelector("[placeholder='First Name']"), user.getFirstName());
        type(By.cssSelector("[placeholder='Last Name']"), user.getLastName());
        type(By.cssSelector("[placeholder='name@example.com']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/sign-in']"));
    }

    public void fillLoginForm() {
        type(By.cssSelector("[placeholder='name@example.com']"), "nm@gm.com");
        type(By.cssSelector("[placeholder='Password']"), "Qwert!1234");
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[contains(text(),'Login')]"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//body/div[1]/div[1]/button[1]/*[1]"));
    }

    public boolean isErrorAccountPresent() {
        return isElementPresent(By.xpath("//*[.='Error while creating account']"));
    }

    public boolean isBookingConfirmationPresent(By xpath) {
        return isBookingConfirmationPresent(By.xpath("//*[.='Booking confirmed']"));
    }
}
