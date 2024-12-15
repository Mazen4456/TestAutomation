package com.gizasystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public  class accountCreatedPage {
    WebDriver driver;

    public accountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public By accountCreatedTitle = By.xpath("//h2[@class='title text-center']");
    public By continueButtonAccountCreated = By.xpath("//a[@data-qa='continue-button']");
    public accountCreatedPage clickOnContinueButton (){
        driver.findElement(continueButtonAccountCreated).click();
        return this;
    }
    public accountCreatedPage assertAccountIsCreated() {
        Assert.assertEquals(driver.findElement(accountCreatedTitle).getText(),"ACCOUNT CREATED!");
        return this;
    }
}