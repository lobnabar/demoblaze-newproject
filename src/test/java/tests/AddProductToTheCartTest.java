package tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetaislPage;

public class AddProductToTheCartTest extends TestBase {

    @Test
    public void userCanAddProductToTheCart() {
        HomePage homePage = new HomePage(driver);
        ProductDetaislPage productPage = new ProductDetaislPage(driver);
        CartPage cartPage = new CartPage(driver);

        // 1. Open product page
        homePage.openFirstProduct();

        // 2. Click Add to cart
        productPage.AddToCart();

        // 3. Handle the pop-up alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        
        homePage.openCartPage();

        // 5. Verify the product is in the cart (The wait handles the delay here now!)
        Assert.assertTrue(cartPage.isProductInCart("Samsung galaxy s6"), "Product not found in cart!");
    }
}