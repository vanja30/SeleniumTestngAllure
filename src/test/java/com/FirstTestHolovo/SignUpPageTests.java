package com.FirstTestHolovo;

import com.Listener.CustomTestNgListener;
import com.page.HomePage;
import com.page.RegisterPage;
import com.page.SignUpPage;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.Driver.ThreadLocalStorageDriver.getDriver;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@Listeners(CustomTestNgListener.class)
public class SignUpPageTests extends BaseTest {
    private SignUpPage signUpPage;

    @DataProvider(name = "email-provider")
    public Object[][] emailDataProvider() {
        return new Object[][]{{"validEmail" + randomAlphanumeric(4) + "@t.com", true},
                {"valid2Email" + randomAlphabetic(4) + "@t.com", true},
                {"invalid2Email" + randomAlphabetic(4) + "t.com", false,}};
    }

    @BeforeMethod
    public void navToSignUpPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickSignUpLink();
        signUpPage = new SignUpPage(getDriver());
    }

    @Test(dataProvider = "email-provider")
    @Description("Sign up users with different emails")
    public void signUpUserWithEmail(String email, boolean isValid) {
        signUpPage
                .fillAllData(email)
                .clickSignUpButton();

        RegisterPage registerPage = new RegisterPage(getDriver());

        Assert.assertEquals(isValid, registerPage.isSuccessMessageDisplayed()
                , "User email and registration page are not properly connected");
        ;
    }
}
