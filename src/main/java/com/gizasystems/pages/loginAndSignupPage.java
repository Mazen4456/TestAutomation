package com.gizasystems.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class loginAndSignupPage {
    WebDriver driver;

    public loginAndSignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public By loginName_field = By.xpath("//input[@data-qa='login-email']");
    public By loginPassword_field = By.xpath("//input[@data-qa='login-password']");
    public By loginSubmitButton = By.xpath("//button[@data-qa='login-button']");
    public By loginTitle = By.xpath("//div[@class='login-form']//h2");
    public By signupUserName = By.xpath("//input[@data-qa='signup-name']");
    public By signupEmail = By.xpath("//input[@data-qa='signup-email']");
    public By signupSubmitButton = By.xpath("//button[@data-qa='signup-button']");
    public By errorLoginMessage = By.xpath("//p[@style='color: red;']");
    public By signupAndLoginButtonColor = By.xpath("//a[@style='color: orange;']");

    @Step("Assert Signup And Signin Page Display")
    public loginAndSignupPage assertSignupAndSignInPageDisplay(){
        driver.findElement(signupAndLoginButtonColor).isDisplayed();
        return this;
    }
    @Step("Assert Login Error Message Appears")
    public loginAndSignupPage assertLoginErrorMessageAppears(){
        driver.findElement(errorLoginMessage).isDisplayed();
        System.out.println(driver.findElement(errorLoginMessage).getText());
        return this;
    }
    @Step("Assert Login Title Appears")
    public loginAndSignupPage assertLoginTitleAppears(){
        Assert.assertEquals(driver.findElement(loginTitle).getText(),"Login to your account");
        return this;
    }
    public loginAndSignupPage signup(String name, String mail) {
        driver.findElement(signupUserName).sendKeys(name);
        driver.findElement(signupEmail).sendKeys(mail);
        driver.findElement(signupSubmitButton).click();
        return this;
    }
    public loginAndSignupPage login(String email, String password){
        driver.findElement(loginName_field).sendKeys(email);
        driver.findElement(loginPassword_field).sendKeys(password);
        driver.findElement(loginSubmitButton).click();
        return this;
    }
}
