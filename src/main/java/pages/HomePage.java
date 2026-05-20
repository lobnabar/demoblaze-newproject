package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Home")
    WebElement homeLink;

    @FindBy(linkText = "Contact")
    WebElement contactLink;

    @FindBy(linkText = "About us")
    WebElement aboutUsLink;

    @FindBy(linkText = "Cart")
    WebElement cartLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(linkText = "Sign up")
    WebElement signUpLink;
    @FindBy(id = "logout2")
    WebElement logoutLink;
    @FindBy(id = "nameofuser")
    WebElement welcomeLink;

    @FindBy(xpath = "//button[text()='Previous']")
    WebElement previousBtn;

    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextBtn;

    @FindBy(xpath = "//a[text()='Phones']")
    WebElement phonesCategory;

    @FindBy(xpath = "//a[text()='Laptops']")
    WebElement laptopsCategory;

    @FindBy(xpath = "//a[text()='Monitors']")
    WebElement monitorsCategory;

    // مثال: أول منتج في الصفحة
    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    WebElement firstProduct;

    // Actions
    public void openHomePage() {
        clickButton(homeLink);
    }

    public void openContactPage() {
        clickButton(contactLink);
    }

    public void openAboutUsPage() {
        clickButton(aboutUsLink);
    }

    public void openCartPage() {
        clickButton(cartLink);
    }

    public void openLogInPage() {
        clickButton(loginLink);
    }

    public void openSignUpPage() {
        clickButton(signUpLink);
    }

    public void selectPhonesCategory() {
        clickButton(phonesCategory);
    }

    public void selectLaptopsCategory() {
        clickButton(laptopsCategory);
    }

    public void selectMonitorsCategory() {
        clickButton(monitorsCategory);
    }

    public boolean isLogoutLinkDisplayed() {
        // This will return true if the element is actually on the screen
        return logoutLink.isDisplayed();
    }

    public WebElement logoutLinkElement() {
        // This returns the actual element so the WebDriverWait can see it
        return logoutLink;
    }
    
    public boolean isWelcomeLinkDisplayed() {
        // This will return true if the element is actually on the screen
        return welcomeLink.isDisplayed();
    }

    public WebElement welcomeLinkElement() {
        // This returns the actual element so the WebDriverWait can see it
        return welcomeLink;	
	}
    public void clickPreviousSlider() {
        clickButton(previousBtn);
}
    public void clickNextSlider() {
        clickButton(nextBtn);
    }
 // Get active indicator
    public WebElement getActiveIndicatorElement() {
        return driver.findElement(By.cssSelector("#carouselExampleIndicators .active"));
    }

    public String getActiveIndicatorClass() {
        return getActiveIndicatorElement().getAttribute("class");
    }
    public void openFirstProduct() {
        clickButton(firstProduct);
    }
}
