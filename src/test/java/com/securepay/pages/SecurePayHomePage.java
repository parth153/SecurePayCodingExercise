package com.securepay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SecurePayHomePage extends BasePage{
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Contact us")
    private WebElement contactUsLink;

    public SecurePayHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ContactUsPage clickContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }
}
