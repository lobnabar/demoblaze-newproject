**Demoblaze Automation Project**
![Java](https://img.shields.io/badge/Java-17-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.40.0-green) ![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red) ![Maven](https://img.shields.io/badge/Maven-Build-blue)

A Selenium WebDriver and TestNG automation project for testing the Demoblaze e-commerce website.

The repository follows the Page Object Model (POM) design pattern and covers core customer journeys, including registration, login, product browsing, cart management, checkout, and contact functionality.

**Features**
Selenium WebDriver browser automation
TestNG test framework
Page Object Model architecture
Maven dependency management
WebDriverManager for automatic ChromeDriver setup
HTML and XML TestNG reports
JUnit-style test reports
Screenshot-ready test structure
**Tested Scenarios**
User sign-up
User login
Product search by category
Adding products to the cart
Placing an order
Sending a contact message
Viewing the About Us section
**Technologies**
Technology	Purpose
Java 17	Programming language
Selenium 4.40.0	Browser automation
TestNG 7.11.0	Test execution and assertions
WebDriverManager 6.3.4	Browser driver management
Apache Maven	Build and dependency management
SLF4J	Logging
Apache Commons IO	File utilities
**Prerequisites**
Before running the project, install:

Java JDK 17 or newer
Apache Maven
Google Chrome
An IDE such as Eclipse or IntelliJ IDEA
Verify the installations:

bash
java -version
mvn -version
Installation
Clone the repository:

bash
git clone https://github.com/lobnabar/demoblaze-newproject.git
cd demoblaze-newproject
Install Maven dependencies:

bash
mvn clean install
Running the Tests
Run the complete TestNG suite:

bash
mvn test
Run the suite using the TestNG configuration:

bash
mvn test -DsuiteXmlFile=testng.xml
The suite runs in Chrome by default. The browser is configured in testng.xml:

XML
<parameter name="browser" value="chrome"/>
TestNG Configuration
**The testng.xml suite includes:**

SignUpTest
LogInTest
SearchByCategoriesTest
AddProductToTheCartTest
PlaceOrderTest
ContactTest
AboutUsTest
**Project Structure**
Text
demoblaze-newproject
├── src
│   ├── main
│   │   └── java
│   │       └── pages
│   │           ├── PageBase.java
│   │           ├── HomePage.java
│   │           ├── SignUpPage.java
│   │           ├── LogInPage.java
│   │           ├── CartPage.java
│   │           ├── PlaceOrderPage.java
│   │           ├── ProductDetaislPage.java
│   │           ├── ContactPage.java
│   │           └── AboutUsPage.java
│   └── test
│       └── java
│           ├── tests
│           │   ├── TestBase.java
│           │   ├── SignUpTest.java
│           │   ├── LogInTest.java
│           │   ├── SearchByCategoriesTest.java
│           │   ├── AddProductToTheCartTest.java
│           │   ├── PlaceOrderTest.java
│           │   ├── ContactTest.java
│           │   └── AboutUsTest.java
│           └── utilities
│               └── Helpers.java
├── test-output
├── logs
├── pom.xml
├── testng.xml
└── target
**Test Reports**
After execution, generated reports are available in:

test-output/index.html — TestNG HTML report
test-output/emailable-report.html — Email-friendly report
test-output/testng-results.xml — XML results
test-output/junitreports/ — JUnit reports
target/surefire-reports/ — Maven reports, when available
Open test-output/index.html in a browser to view the detailed test report.

**Design Pattern**
The project uses the Page Object Model pattern:

Page classes define locators and actions for each web page.
Test classes define test scenarios and assertions.
PageBase provides reusable page-level functionality.
TestBase manages WebDriver setup and browser cleanup.
Utility classes contain helper methods shared across tests.
**Notes**
ChromeDriver is managed automatically by WebDriverManager.
Generated directories such as target/ and test-output/ are typically excluded from source control.
Test data should be updated if the Demoblaze website changes its UI or registration behavior.
Internet access is required while running the tests.
Contributing
Contributions are welcome:

**Fork the repository.**
Create a feature branch.
Add or update test coverage.
Run the full Maven suite.
Submit a pull request.
License
No license has been specified for this repository.
