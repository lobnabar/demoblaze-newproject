package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy (css = "button.btn.btn-success")
	WebElement PlaceOrderBtn;
	
	public void PlaceOrder()
    {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOf(PlaceOrderBtn));
    	clickButton(PlaceOrderBtn);
    }
	public boolean isProductInCart(String productName) { 
        // Build the locator dynamically using the provided product name
        By productTitle = By.xpath("//td[text()='" + productName + "']");
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
            wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
            return true;
        } catch (Exception e) {
            // If the element isn't found/visible within the timeout, return false
            return false;
        }
        
    }
}