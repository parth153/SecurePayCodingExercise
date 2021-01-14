package com.securepay.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverConfigImpl implements WebDriverConfig{

    WebDriver webDriver = null;


    @Override
    public void initWebDriver(String browserType, String pathToDriverBinaries) throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        switch (browserType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", pathToDriverBinaries + "/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                webDriver = new ChromeDriver(desiredCapabilities);
                break;
            default:
                throw new Exception("Browser type not supported at the moment");
        }
    }

    @Override
    public void tearDownWebDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

    @Override
    public WebDriver getWebDriver() {
        return webDriver;
    }
}
