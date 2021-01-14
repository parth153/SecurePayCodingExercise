package com.securepay.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage{
    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@type=\"text\"]")
    private WebElement searchBox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"rso\"]//a[@href=\"https://www.securepay.com.au/\"]")
    private WebElement securePayLink;

    @FindBy(how = How.ID, using = "res")
    private WebElement searchResults;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate() {
        driver.navigate().to("https://www.google.com/");
    }

    public void typeSearchText(String searchText) {
        searchBox.sendKeys(searchText + Keys.ENTER);
    }

    public SecurePayHomePage clickSecurePayWebSite() {
        waitForElementToBeVisible(searchResults, driver);
        securePayLink.click();
        return new SecurePayHomePage(driver);
    }
}
