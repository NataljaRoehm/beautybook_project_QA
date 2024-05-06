package beautybook.UI.pages.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    WebDriver driver;

    UserHelper user;
    HomePageHelper homepage;

    BookingHelper booking;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    @BeforeMethod
    public void init() {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.get("https://beaty-project-2-0-dwyu.vercel.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homepage = new HomePageHelper(driver);
        booking = new BookingHelper(driver);
    }

    public BookingHelper getBooking() {
        return booking;
    }

    public UserHelper getUser() {
        return user;
    }

    public HomePageHelper getHomepage() {
        return homepage;
    }

    public void stop() {
        driver.quit();

    }
}
