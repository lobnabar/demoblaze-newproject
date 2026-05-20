package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrderPage extends PageBase {

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(id = "name")
	
    WebElement nameField;

    @FindBy(id = "country")
    WebElement countryField;

    @FindBy(id = "city")
    WebElement cityField;

    @FindBy(id = "card")
    WebElement creditCardField;

    @FindBy(id = "month")
    WebElement monthField;

    @FindBy(id = "year")
    WebElement yearField;

    @FindBy (xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;

    // Methods using sendKeys
    public void setName(String name) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void setCountry(String country) {
        countryField.clear();
        countryField.sendKeys(country);
    }

    public void setCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public void setCreditCard(String cardNumber) {
        creditCardField.clear();
        creditCardField.sendKeys(cardNumber);
    }

    public void setMonth(String month) {
        monthField.clear();
        monthField.sendKeys(month);
    }

    public void setYear(String year) {
        yearField.clear();
        yearField.sendKeys(year);
    }

    public void clickPurchase() {
        purchaseBtn.click();
    }

	public void closeConfirmation() {
		// TODO Auto-generated method stub
		
	}
}

