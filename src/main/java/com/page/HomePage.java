package com.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(name = "username")
    WebElement useNameTextBox;

    @FindBy(name = "password")
    WebElement passwordTextBox;

    @FindBy(css = "input[type='submit']")
    WebElement loginButton;

    @FindBy(css = "a[href='signup']")
    WebElement signUpLink;

    @FindBy(css = "a[href='login']")
    WebElement loginLink;

    //css is faster, just to show that I am familiar with xpaths
    @FindBy(xpath = "//a[@class='fb btn']")
    WebElement facebookButton;

    @FindBy(xpath = "//a[@class='twitter btn']")
    WebElement twitterButton;

    @FindBy(xpath = "//a[@class='google btn']")
    WebElement googleButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Set user name")
    public HomePage setUserName(String userName) {
        useNameTextBox.sendKeys(userName);
        return this;
    }

    @Step("Set password")
    public HomePage setPassword(String password) {
        passwordTextBox.sendKeys(password);
        return this;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Login button not displayed")
    public void validateLoginButtonNotVisible() {
        waitUntilElementNotVisible(loginButton, 10);
    }

    @Step("Login button displayed")
    public void validateLoginButtonVisible() {
        waitUntilElementVisible(loginButton, 10);
    }

    @Step("Click login link")
    public void clickLoginLink() {
        loginLink.click();
    }

    @Step("Click signUp link")
    public void clickSignUpLink() {
        signUpLink.click();
    }

    @Step("Click facebook button")
    public void clickFacebookButton() {
        facebookButton.click();
    }

    @Step("Click Twitter button")
    public void clickTwitterButton() {
        twitterButton.click();
    }

    @Step("Click Google button")
    public void clickGoogleButton() {
        googleButton.click();
    }

}
