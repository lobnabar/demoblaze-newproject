package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

    protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select;
    public Actions action;

    // Constructor
    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }

    // Common Actions
    protected void clickButton(WebElement element) {
        element.click();
    }

    protected void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    public void scrollToBottom() {
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void clearText(WebElement element) {
        element.clear();
    }

    // Extra utilities for DemoBlaze
    public void hoverOverElement(WebElement element) {
        action.moveToElement(element).perform();
    }

    public void selectFromDropdown(WebElement element, String visibleText) {
        select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
}

