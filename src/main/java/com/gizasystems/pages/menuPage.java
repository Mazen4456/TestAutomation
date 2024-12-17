package com.gizasystems.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class menuPage {
    public menuPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    public By loginButton = By.xpath("//a[@href='/login']");
    public By homePageButton = By.xpath("//i[@class='fa fa-home']");
    public By productButton = By.xpath("//a[@href='/products']");
    public By cartButton = By.xpath("//a[@href='/view_cart']/i");
    public By videoButton = By.xpath("//a[@href='https://www.youtube.com/c/AutomationExercise']");
    public By logoutButton = By.xpath("//a[@href='/logout']");
    public By deleteAccountButton = By.xpath("//a[@href='/delete_account']");

    @Step("click On Login Button")
    public menuPage clickOnLoginButton (){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(loginButton).click();
        return this;
    }
    public menuPage clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
        return this;
    }
}
