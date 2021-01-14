Feature: Submit form on Contact Us Page

  As a user navigated to secure pay from google search, user submits form on the contact us page

  Scenario Outline: User submits the form on Contact us page
    Given The user is on "<Browser Type>" browser
    And The user navigates to Google Home Page
    Then The user types "SecurePay" in Google Search box
    Then The user clicks on SecurePay website
    Then The user navigates to the Contact Us Page
    Then The user verifies Contact Us Page is loaded
    Then The user fills in data in contact us form
    Examples:
      | Browser Type |
      | CHROME       |
