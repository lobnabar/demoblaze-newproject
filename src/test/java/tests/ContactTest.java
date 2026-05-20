package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactPage;
import pages.HomePage;
import pages.SignUpPage;

public class ContactTest extends TestBase  {
	HomePage homeObject;
    ContactPage contactPage;

    @Test
    public void userCanContactSuccessively() {
        homeObject = new HomePage(driver);

        // افتح الصفحة الرئيسية
        driver.get("https://www.demoblaze.com/");

        // استخدم الميثود اللي بتفتح المودال بتاع الـ Sign Up
        homeObject.openContactPage();

        // أنشئ صفحة SignUpPage
        contactPage = new ContactPage(driver);

        // نفذ عملية التسجيل
        String email = "lobna@test.com";
        String name = "lobna";
        String message = "Hello I have a question about your products";
        contactPage.userContact(email, name, message);
        
        // التحقق من رسالة الـ Alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Thanks for the message!!");
        
    }
}
