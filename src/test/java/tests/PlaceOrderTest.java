package tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ProductDetaislPage;

public class PlaceOrderTest extends TestBase{
	
	@Test
    public void userCanPlaceOrder() {
        HomePage homePage = new HomePage(driver);
        ProductDetaislPage productPage = new ProductDetaislPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.openFirstProduct();
        productPage.AddToCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        homePage.openCartPage();
	    cartPage.PlaceOrder();
	    PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        placeOrderPage.setName("Lobna");
        placeOrderPage.setCountry("Egypt");
        placeOrderPage.setCity("Cairo");
        placeOrderPage.setCreditCard("1234 5678 9012 3456");
        placeOrderPage.setMonth("12");
        placeOrderPage.setYear("2030");
        placeOrderPage.clickPurchase();
       
        WebElement confirmationMessage = wait.until(
         ExpectedConditions.visibilityOfElementLocated(
        		 By.xpath("//h2[text()='Thank you for your purchase!']")));

     String messageText = confirmationMessage.getText();
     Assert.assertEquals(messageText, "Thank you for your purchase!");
     placeOrderPage.closeConfirmation();
        
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


