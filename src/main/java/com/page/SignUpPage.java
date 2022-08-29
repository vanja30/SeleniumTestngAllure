package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class SignUpPage extends BasePage {

    //TODO: Change locator when defect for double first name is fixed
    @FindBy(xpath = "//input[@name='user_fname'][1]")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='user_fname'][2]")
    WebElement firstName2;

    @FindBy(name = "username")
    WebElement lastName;

    @FindBy(name = "user_email")
    WebElement userEmail;

    @FindBy(name = "user_pass")
    WebElement userPassword;

    @FindBy(name = "user_mobile")
    WebElement userMobile;

    @FindBy(css = "button[class='cancelbtn']")
    WebElement cancelButton;

    @FindBy(css = "button[class='signupbtn']")
    WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Set user first name")
    public SignUpPage setFirstName(String inputText) {
        firstName.sendKeys(inputText);
        return this;
    }

    @Step("Set user last name")
    public SignUpPage setLastName(String inputText) {
        lastName.sendKeys(inputText);
        return this;
    }

    @Step("Set user email")
    public SignUpPage setUserEmail(String inputText) {
        userEmail.sendKeys(inputText);
        return this;
    }

    @Step("Set user password")
    public SignUpPage setUserPassword(String inputText) {
        userPassword.sendKeys(inputText);
        return this;
    }

    @Step("Set user mobile number")
    public SignUpPage setUserMobileNumber(String inputText) {
        userMobile.sendKeys(inputText);
        return this;
    }

    @Step("Click cancel button")
    public void clickCancelButton() {
        cancelButton.click();
    }

    @Step("Sign up button not displayed")
    public void validateLoginButtonNotVisible() {
        waitUntilElementNotVisible(signUpButton, 10);
    }

    @Step("Click Sign Up button")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    @Step("Fill all data for sign up")
    public SignUpPage fillAllData(String userEmail) {
        //TODO: Remove after fix defect for duplicated first name
        firstName2.sendKeys("whatever");
        this
                .setFirstName(randomAlphabetic(10))
                .setLastName(randomAlphabetic(20))
                .setUserEmail(userEmail)
                .setUserPassword(randomAlphabetic(6))
                .setUserMobileNumber(randomNumeric(9));
        return this;
    }

}

