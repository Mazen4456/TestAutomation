package com.gizasystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class homePage {
    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    public By orangeColorForHomeIcon = By.xpath("//a[@style='color: orange;']//i[@class='fa fa-home']");
    public By logedInName = By.xpath("//a[text()=' Logged in as ']//b[text()='mazen']");
    public By logoutButton = By.xpath("//a[@href='/logout']");

    public homePage clickOnLogoutButton() {
        driver.findElement(logoutButton).click();
        return this;

    }

    public homePage assertLogedUserNameAppears(String userName) {
        Assert.assertEquals(driver.findElement(logedInName).getText(), userName);
        return this;
    }

    public homePage assertHomePageIconIsOrange() {
        driver.findElement(orangeColorForHomeIcon).isDisplayed();
        return this;
    }

    public homePage navigateToUrl(String url) {
        driver.get(url);
        return this;
    }

}

