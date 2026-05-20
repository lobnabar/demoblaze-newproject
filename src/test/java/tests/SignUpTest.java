package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignUpPage;

public class SignUpTest extends TestBase {

    HomePage homeObject;
    SignUpPage signUpPage;

    @Test
    public void userCanSignUpSuccessfully() {
        homeObject = new HomePage(driver);

        // افتح الصفحة الرئيسية
        driver.get("https://www.demoblaze.com/");

        // استخدم الميثود اللي بتفتح المودال بتاع الـ Sign Up
        homeObject.openSignUpPage();

        // أنشئ صفحة SignUpPage
        signUpPage = new SignUpPage(driver);

        // نفذ عملية التسجيل
        String testUsername = "lobna" + System.currentTimeMillis();
        String testPassword = "Password@123";

        signUpPage.userSignUp(testUsername, testPassword);

        // التحقق من رسالة الـ Alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Sign up successful.");
        
        // قبول الـ Alert
        driver.switchTo().alert().accept();
    }
}
