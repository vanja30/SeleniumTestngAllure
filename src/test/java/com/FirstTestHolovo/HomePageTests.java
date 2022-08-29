package com.FirstTestHolovo;

import com.Driver.SingleDriverCreation;
import com.Listener.CustomTestNgListener;
import com.page.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.io.IOException;

import static com.Driver.ThreadLocalStorageDriver.getDriver;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

@Listeners(CustomTestNgListener.class)
public class HomePageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setHomePage(){
        homePage = new HomePage(getDriver());
    }

    @Test
    @Description("Use random user name and password and verify that user is not logged in")
    public void loginButton() throws IOException {
        homePage
                .setUserName(randomAlphanumeric(10))
                .setPassword(randomAlphanumeric(5))
                .clickLoginButton();

        homePage.validateLoginButtonVisible();
    }
}