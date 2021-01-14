package com.securepay.utils;

import org.openqa.selenium.WebDriver;

public interface WebDriverConfig {

    void initWebDriver(String browserType, String pathToDriverBinaries) throws Exception;

    void tearDownWebDriver();

    WebDriver getWebDriver();
}
