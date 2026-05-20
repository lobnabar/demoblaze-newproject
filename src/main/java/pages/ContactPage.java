package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends PageBase{

	public ContactPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	} 
	@FindBy(id = "recipient-email")
    WebElement contactEmailField;

    @FindBy(id = "recipient-name")
    WebElement contactNameField;
    @FindBy(id = "message-text")
    WebElement messageField;


    @FindBy(xpath = "//button[text()='Send message']")
    WebElement sendMessageBtn;
    
    // Actions
    public void userContact(String email, String name, String message) { 
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactEmailField));
        sendKeys(contactEmailField, email);
        sendKeys(contactNameField, name);
        sendKeys(messageField, message);
        clickButton(sendMessageBtn);
    }
	
	

}
