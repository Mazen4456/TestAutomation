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
import org.testng.annotations.Test;
import utiliteis.DriverFactory;
import utiliteis.JsonFileManager;
import utiliteis.PropertiesReader;

public class InvalidLoginTest {
        WebDriver driver;
        private JsonFileManager jsonFileManager;


    @BeforeClass
        public void beforeClass() {
        PropertiesReader.loadProperties();
            driver = DriverFactory.driverSetUp(System.getProperty("browserName"),true,false);
           /* driver.manage().window().maximize();*/
            jsonFileManager = new JsonFileManager("src/test/resources/testDataJsonFiels/autimationExerciseData.json");

    }

        @Test
        @Description("Assert Home Page Displayed")
        @Severity(SeverityLevel.CRITICAL)
        public void test1HomePageIsDisplayed() {
            new homePage(driver)
                    .navigateToUrl(jsonFileManager.getTestData("url"))
                    .assertHomePageIconIsOrange();
        }

        @Test
        @Description("Asser Login Error Message Appears")
        @Severity(SeverityLevel.CRITICAL)
        public void test2loginToYourAccountVisible() {
                    new menuPage(driver)
                    .clickOnLoginButton();
            new loginAndSignupPage(driver)
                    .assertLoginTitleAppears()
                    .login(jsonFileManager.getTestData("email"), jsonFileManager.getTestData("password"))
                    .assertLoginErrorMessageAppears();
        }

        @AfterClass
        public void quitDriver() {
            driver.quit();
         }


    }