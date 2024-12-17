package automationEx;

import com.gizasystems.pages.homePage;
import com.gizasystems.pages.menuPage;
import com.gizasystems.pages.loginAndSignupPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utiliteis.DriverFactory;
import utiliteis.JsonFileManager;
import utiliteis.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class InvalidLoginTest {
        WebDriver driver;
        private JsonFileManager jsonFileManager;


        @BeforeClass
        private void loggingProperties() {
        PropertiesReader.loadProperties();
        }
        @BeforeMethod
        private void setup() {
        driver = DriverFactory.driverSetUp(System.getProperty("browserName"),true, Boolean.parseBoolean(System.getProperty("headless")));
        jsonFileManager = new JsonFileManager("src/test/resources/testDataJsonFiles/automationExerciseData.json");
        }

        @Test
        @Description("Assert Home Page Displayed")
        @Severity(SeverityLevel.CRITICAL)
        public void test1HomePageIsDisplayed() {
            new homePage(driver)
                    .navigateToUrl(jsonFileManager.getTestData("url"))
                    .assertHomePageIconIsOrange();
            new menuPage(driver)
                    .clickOnLoginButton();
            new loginAndSignupPage(driver)
                    .assertLoginTitleAppears()
                    .login(jsonFileManager.getTestData("email"), jsonFileManager.getTestData("password"))
                    .assertLoginErrorMessageAppears();
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
         }


    }