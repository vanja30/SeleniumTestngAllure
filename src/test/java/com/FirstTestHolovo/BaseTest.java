package com.FirstTestHolovo;

import com.Driver.SingleDriverCreation;
import com.Listener.CustomTestNgListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.Constants.BASE_URL;
import static com.Driver.ThreadLocalStorageDriver.getDriver;
import static com.Driver.ThreadLocalStorageDriver.setDriver;

public class BaseTest {

    @BeforeMethod
    public void before() throws IOException {
        setDriver(SingleDriverCreation.initializeDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().get(BASE_URL);
    }

    @AfterMethod
    public void after() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
