package com.securepay.pages;

import com.securepay.testData.SupportFormData;
import io.cucumber.java.eo.Se;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class ContactUsPage extends BasePage{
    private WebDriver driver;

    @FindBy(how = How.LINK_TEXT, using = "Contact us")
    private WebElement contactUsLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"support-form\"]")
    private WebElement supportForm;

    @FindBy(how = How.XPATH, using = "//input[@name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = "//input[@name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@name=\"email\"]")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//input[@name=\"phone\"]")
    private WebElement phoneNumber;

    @FindBy(how = How.XPATH, using = "//input[@name=\"company\"]")
    private WebElement company;

    @FindBy(how = How.XPATH, using = "//input[@name=\"website\"]")
    private WebElement website;

    @FindBy(how = How.XPATH, using = "//textarea[@name=\"message\"]")
    private WebElement message;

    @FindBy(how = How.XPATH, using = "//select[@name=\"amount\"]")
    private WebElement amount;

    @FindBy(how = How.ID, using = "existingCustomer")
    private WebElement existingCustomer;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean submitFormIsDisplayed() {
        waitForElementToBeVisible(supportForm, driver);
        return supportForm.isDisplayed();
    }

    public void fillRandomDetailsSupportForm() {
        SupportFormData supportFormData = new SupportFormData();
        firstName.sendKeys(supportFormData.getFirstName());
        lastName.sendKeys(supportFormData.getLastName());
        email.sendKeys(supportFormData.getWorkEmail());
        phoneNumber.sendKeys(supportFormData.getPhoneNumber());
        company.sendKeys(supportFormData.getCompanyName());
        website.sendKeys(supportFormData.getWebsiteURL());
        Select select = new Select(amount);
        select.selectByIndex(RandomUtils.nextInt(0,7));
        message.sendKeys(supportFormData.getMessage());
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click()", existingCustomer);
    }
}
