package com.securepay.testData;

import com.github.javafaker.Faker;

public class SupportFormData {

    private final String firstName;
    private final String lastName;
    private final String workEmail;
    private final String phoneNumber;
    private final String companyName;
    private final String websiteURL;
    private final String message;

    public SupportFormData() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        workEmail = firstName + "." + lastName + "@gmail.com";
        phoneNumber = faker.phoneNumber().phoneNumber();
        companyName = faker.company().name();
        websiteURL = faker.company().url();
        message = faker.backToTheFuture().quote();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public String getMessage() {
        return message;
    }
}
