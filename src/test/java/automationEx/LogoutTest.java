package automationEx;
import com.gizasystems.pages.homePage;
import com.gizasystems.pages.menuPage;
import com.gizasystems.pages.loginAndSignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LogoutTest {

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    public void test1HomePageIsDisplayed() {
        new homePage(driver)
                .navigateToUrl("https://automationexercise.com")
                .assertHomePageIconIsOrange();
    }

    @Test
    public void test2loginToYourAccountVisible() {
        new homePage(driver)
                .navigateToUrl("https://automationexercise.com");
        new menuPage(driver)
                .clickOnLoginButton();
        new loginAndSignupPage(driver)
                .assertLoginTitleAppears()
                .login("mazen@test.com", "password");
        new homePage(driver)
                .assertLogedUserNameAppears("mazen");
    }

    @Test
    public void test3Logout() {
        new homePage(driver)
                .clickOnLogoutButton();
        new loginAndSignupPage(driver)
                .assertSignupAndSignInPageDisplay();


    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }


}
