# CodingExercise-SecurePay

![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)

### This is a coding exercise. The solution is built on MAC OS with MAVEN, JAVA, Cucumber (BDD style) and Selenium.

  - The source code is under src directory. Feature file is located under src/test/resources/features.
  - The step definitions are located under src/test/java/com/securepay/stepdefs.
  - The page objects are located under src/test/java/com/securepay/pages.
  - The artifacts of the run are generated under target folder after running it.

## Steps to Run the suite

Suite requires git to checkout code repository.
Suite requires JAVA, MAVEN and Chrome version 87 to be installed.

## Note - To run this suite on Windows, System property needs to be updated in WebDriverConfigImpl.java file as -                 
System.setProperty("webdriver.chrome.driver", pathToDriverBinaries + "/chromedriver.exe");


#### Step 1 - Source Code checkout
clone the remote repository to the local environment. 
```sh
$ git clone https://github.com/parth153/SecurePayCodingExercise.git
```

#### Step 2 - Install dependencies and run test
```mvn clean install``` (creates artifacts .jar) if not required then just - ```mvn clean test``` command.

Html report 'cucumber-reports.html' is generated under target folder after the BUILD SUCCESS.

