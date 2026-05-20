package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;

public class LogInTest extends TestBase {

    HomePage homeObject;
    LogInPage loginPage;

    @Test(priority =1)
    public void userCanLoginSuccessfully() {
        // Initialize Page Objects
        homeObject = new HomePage(driver);
        loginPage = new LogInPage(driver);

        // 1. Open the URL (Note: It's better to put this in TestBase)
        driver.get("https://www.demoblaze.com/");

        // 2. Open Login Modal
        homeObject.openLogInPage();

        // 3. Perform Login
        String Username = "lobna" ;
        String Password = "lobna123";
        
        loginPage.userLogin(Username, Password);
        // 4. Verification
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homeObject.logoutLinkElement()));
        wait.until(ExpectedConditions.visibilityOf(homeObject.welcomeLinkElement()));
        Assert.assertTrue(homeObject.isLogoutLinkDisplayed(), "Log out link should be visible after login.");
        Assert.assertTrue(homeObject.isWelcomeLinkDisplayed(), "Welcome link should be visible after login.");
    }
 // Test Slider Functionality After Login
    @Test(priority = 2)
    public void testSliderFunctionalityAfterLogin() {
        homeObject = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. تأكيد وجود السلايدر
        WebElement slider = driver.findElement(By.id("carouselExampleIndicators"));
        Assert.assertTrue(slider.isDisplayed()); 

        // 2. اضغطي على Next
        homeObject.clickNextSlider();

        // 3. انتظري أن الزر يكون قابل للضغط مرة أخرى (دليل أن العملية تمت)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-slide='next']")));
        
        // 4. اضغطي على Previous
        homeObject.clickPreviousSlider();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-slide='prev']")));

        // 5. Assertion نهائي للتأكيد أن السلايدر موجود بعد التفاعل
        Assert.assertTrue(slider.isDisplayed());
        
    }
}