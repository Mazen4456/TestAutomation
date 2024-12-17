package automationEx;

import com.gizasystems.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utiliteis.JsonFileManager;

public class RegAndDeleteAccount {
    WebDriver driver;
    private JsonFileManager jsonFileManager;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        jsonFileManager = new JsonFileManager("src/test/resources/testDataJsonFiels/autimationExerciseData.json");
    }
    @Test
    public void test1HomePageIsDisplayed (){
        new homePage(driver)
                .navigateToUrl("https://automationexercise.com")
                .assertHomePageIconIsOrange();
    }
    @Test
    public void test2CreateAccount() {
        new homePage(driver)
                .navigateToUrl("https://automationexercise.com");
        new menuPage(driver)
                .clickOnLoginButton();
        new loginAndSignupPage(driver)
                .signup("mazen", "mazen@test.com");
        new registerPage(driver)
                .assertTheTitleIsVisible()
                .fillingAccountInformationToRegister("password", jsonFileManager.getTestData("userName"), "Amer")
                .fillingAddressInformationToRegister("24 taqa", "Cairo", "Nasr City", "44332", "01114002970");
        new accountCreatedPage(driver)
                .assertAccountIsCreated()
                .clickOnContinueButton();
    }
    @Test
    public void test3LogedinUserNameAppearsInHomePage(){
        new homePage(driver).assertLogedUserNameAppears("mazen");
    }
    @Test
    public void test4DeleteAccount(){
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