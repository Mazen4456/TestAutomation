package utiliteis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    static WebDriver driver;

    public static WebDriver iniatieDriver(String browserName, Boolean maximize) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("fireFox")) {
            driver = new FirefoxDriver();
        }
        if (maximize = true) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}
