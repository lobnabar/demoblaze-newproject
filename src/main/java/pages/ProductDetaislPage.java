package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetaislPage extends PageBase {

	public ProductDetaislPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement addToCartBtn;
	public void AddToCart()
    {
    	clickButton(addToCartBtn);
    }
	public void acceptProductAddedAlert() {
		// TODO Auto-generated method stub
		
	}
}

