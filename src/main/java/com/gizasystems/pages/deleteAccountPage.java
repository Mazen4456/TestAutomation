package com.gizasystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class deleteAccountPage {
    WebDriver driver;

    public deleteAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public By accountDeletedTitle = By.xpath("//h2[@data-qa=\"account-deleted\"]");


    public deleteAccountPage assertAccountIsDeleted() {
        Assert.assertEquals(driver.findElement(accountDeletedTitle).getText(), "ACCOUNT DELETED!");
        return this;
    }
}
