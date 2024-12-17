package com.gizasystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utiliteis.JsonFileManager;

public class registerPage {
    public registerPage(WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;
    private JsonFileManager jsonFileManager;
    public By genderMaleCheckBox = By.id("id_gender1");
    public By passwordField = By.id("password");
    public By daysField = By.name("days");
    public By day11 = By.xpath("//div[@id='uniform-days']//option[@value='11']");
    public By monthsField = By.id("months");
    public By monthMarch = By.xpath("//select[@id='months']//option[@value='3']");
    public By yearField = By.id("years");
    public By year2001 = By.xpath("//option[@value='2001']");
    public By firstNameField = By.name("first_name");
    public By lastNameField = By.name("last_name");
    public By addressField = By.id("address1");
    public By countryOptions = By.id("country");
    public By countryCanadaOption = By.xpath("//option[@value='Canada']");
    public By stateField = By.id("state");
    public By cityField = By.id("city");
    public By zipField = By.id("zipcode");
    public By mobileNumberField = By.id("mobile_number");
    public By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    public By enterAccountInformationTitle = By.xpath("//h2[@class='title text-center']/b");

    public registerPage fillingAccountInformationToRegister(String password, String firstName, String lastName) {
        driver.findElement(genderMaleCheckBox).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(daysField).click();
        driver.findElement(day11).click();
        driver.findElement(monthsField).click();
        driver.findElement(monthMarch).click();
        driver.findElement(yearField).click();
        driver.findElement(year2001).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }
    public registerPage assertTheTitleIsVisible (){
        Assert.assertEquals(driver.findElement(enterAccountInformationTitle).getText(),"ENTER ACCOUNT INFORMATION");
        return this;
    }

    public void fillingAddressInformationToRegister(String address, String state, String city, String zip, String phoneNum) {
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(countryOptions).click();
        driver.findElement(countryCanadaOption).click();
        driver.findElement(stateField).sendKeys(state);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(mobileNumberField).sendKeys(phoneNum);
        driver.findElement(createAccountButton).click();
    }


}
