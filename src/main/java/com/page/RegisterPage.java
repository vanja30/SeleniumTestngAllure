package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage{

    @FindBy(xpath = "//h3[contains(text(),'User has been successfully')]")
    WebElement successMessage;

    @FindBy(xpath = "//a")
    WebElement homeLink;

    public RegisterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isSuccessMessageDisplayed(){
        return successMessage.isDisplayed();
    }
}
