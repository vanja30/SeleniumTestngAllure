package com.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class SingleDriverCreation {
    public static Properties prop;
    public static String downloadPath;

    public static WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\main\\resources\\app.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");
        String browserHeadless = prop.getProperty("headless");
        downloadPath = System.getProperty("user.dir") + "\\tempDownloadedFiles";

        if (browserName.contains("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            if (browserHeadless.contains("true")) {
                options.addArguments("--headless");
            }

            WebDriverManager.chromedriver().setup();

            //Set Download path for Chrome
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadPath);
            options.setExperimentalOption("prefs", chromePrefs);

            DesiredCapabilities dc = DesiredCapabilities.chrome();
            dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            options.setExperimentalOption("prefs", chromePrefs);
            options.merge(dc);

            return new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            //Create FireFox Profile object
            FirefoxOptions options = new FirefoxOptions();

            options.setAcceptInsecureCerts(true);

            options.addPreference("browser.download.folderList", 2);
            options.addPreference("browser.helperApps.alwaysAsk.force", false);
            options.addPreference("browser.download.dir", downloadPath);
            options.addPreference("browser.download.defaultFolder", downloadPath);
            options.addPreference("browser.download.manager.showWhenStarting", false);
            options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");

            return new FirefoxDriver(options);
        } else {
            throw new RuntimeException("Please set choreme or firefox direver in app.properties file");
        }

    }

    public String GetDownloadPath() {
        return downloadPath;
    }
}


