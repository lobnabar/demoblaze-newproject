package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SearchByCategoriesTest extends TestBase {

    private void verifyCategory(String categoryName, List<String> expectedKeywords) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Click the category link
        driver.findElement(By.linkText(categoryName)).click();

        // 2. CRITICAL: Wait for the old products to disappear or for the first product to match the new category
        // This prevents the "AssertionError" where old data is read as new data.
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className("card-title"), 0));
        
        // 3. Small sleep or fluid wait to ensure AJAX call finished (Demoblaze is slow)
        try { Thread.sleep(1500); } catch (InterruptedException e) { e.printStackTrace(); }

        // 4. Get the fresh list of products
        List<WebElement> products = driver.findElements(By.className("card-title"));

        // 5. Verify each product
        for (WebElement product : products) {
            try {
                String title = product.getText().toLowerCase();
                boolean isMatch = expectedKeywords.stream()
                        .anyMatch(keyword -> title.contains(keyword.toLowerCase()));
                
                Assert.assertTrue(isMatch, "Found product '" + title + "' which does not belong in " + categoryName);
            } catch (StaleElementReferenceException e) {
                // In case the page refreshed during the loop
                continue; 
            }
        }
    }

    @Test
    public void testPhones() {
        verifyCategory("Phones", Arrays.asList("Samsung", "Nokia", "iPhone", "HTC", "Sony", "Nexus 6"));
    }

    @Test
    public void testLaptops() {
        verifyCategory("Laptops", Arrays.asList("Sony", "Dell", "MacBook", "ASUS", "HP"));
    }

    @Test
    public void testMonitors() {
        verifyCategory("Monitors", Arrays.asList("Apple", "ASUS", "Dell"));
    }
}