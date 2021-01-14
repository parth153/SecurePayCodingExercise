package com.securepay.stepdefs;

import com.securepay.pages.ContactUsPage;
import com.securepay.pages.GoogleHomePage;
import com.securepay.pages.SecurePayHomePage;
import com.securepay.utils.PropertyFileManager;
import com.securepay.utils.WebDriverConfigImpl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactUsSubmitFormSteps {

    Logger logger = Logger.getLogger(ContactUsSubmitFormSteps.class.getName());

    WebDriverConfigImpl webDriverConfig = null;
    GoogleHomePage googleHomePage = null;
    SecurePayHomePage securePayHomePage = null;
    ContactUsPage contactUsPage = null;
    Properties properties = null;

    @Before
    public void setUp() throws IOException {
        properties = (new PropertyFileManager()).getProps();
    }

    @Given("The user is on {string} browser")
    public void initializeWebDriver(String browserType) throws Exception {
        webDriverConfig = new WebDriverConfigImpl();
        webDriverConfig.initWebDriver(browserType, properties.getProperty("driverBinaries"));
        logger.log(Level.INFO, "WebDriver initialized");
    }

    @And("The user navigates to Google Home Page")
    public void navigateToGoogleHomePage() throws Exception {
        googleHomePage = new GoogleHomePage(webDriverConfig.getWebDriver());
        googleHomePage.navigate();
        logger.log(Level.INFO, "Navigated to Google Home Page");
    }

    @Then("The user types {string} in Google Search box")
    public void searchSecurePay(String searchText) throws Exception {
        googleHomePage.typeSearchText(searchText);
        logger.log(Level.INFO, "Search Text Entered on Google Page");
    }

    @Then("The user clicks on SecurePay website")
    public void clickSecurePayWebsite() throws Exception {
        securePayHomePage = googleHomePage.clickSecurePayWebSite();
        logger.log(Level.INFO, "SecurePay Link clicked");
        Assert.assertEquals("Secure Pay Home Page Title is not correct",
                properties.getProperty("securePayPageTitle"), securePayHomePage.getTitle(webDriverConfig.getWebDriver()));
        logger.log(Level.INFO, "SecurePay Page displayed");
    }

    @Then("The user navigates to the Contact Us Page")
    public void navigateContactUsPage() throws Exception {
        contactUsPage = securePayHomePage.clickContactUsLink();
        logger.log(Level.INFO, "Contact Us Link clicked");
    }

    @Then("The user verifies Contact Us Page is loaded")
    public void verifyContactUsPageLoaded() throws Exception {
        contactUsPage.waitForPageLoaded(webDriverConfig.getWebDriver());
        Assert.assertTrue("Support Form is not displayed", contactUsPage.submitFormIsDisplayed());
        Assert.assertEquals("Contact Us Page Title is not correct",
                properties.getProperty("contactUsPageTitle"), contactUsPage.getTitle(webDriverConfig.getWebDriver()));
        logger.log(Level.INFO, "Contact Us Page displayed");
    }

    @Then("The user fills in data in contact us form")
    public void fillSupportForm() throws Exception {
        contactUsPage.fillRandomDetailsSupportForm();
        logger.log(Level.INFO, "Support form data filled in");
    }

    @After
    public void tearDown() {
        webDriverConfig.tearDownWebDriver();
    }
}
