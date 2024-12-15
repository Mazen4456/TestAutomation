package automationEx;

import com.gizasystems.pages.*;
import com.gizasystems.pages.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class validlogin {
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
    public void test2loginToYourAccountVisable() {
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
    public void test3DeleteAccount(){
        new menuPage(driver)
                .clickDeleteAccount();
        new deleteAccountPage(driver)
                .assertAccountIsDeleted();
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
    }


}
