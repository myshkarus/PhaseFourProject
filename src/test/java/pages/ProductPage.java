package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProductPage extends Page {

	private By addToCartButton = By.xpath("//android.widget.TextView[@text='Add to cart']");
	private By goToCartButton = By.xpath("//android.widget.TextView[@text='GO TO CART']");
	private By goToCartButton2 = By.xpath("//android.widget.TextView[@text='Go to cart']");
	
	public ProductPage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	public ProductPage addToCart() {
		wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
		driver.findElement(addToCartButton).click();
		return this;
	}

	// Two different buttons 'Go to cart' is possible
	public CartPage goToCart() {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(goToCartButton));
		driver.findElement(goToCartButton).click();
		}
		catch(NoSuchElementException e) {
			wait.until(ExpectedConditions.presenceOfElementLocated(goToCartButton2));
			driver.findElement(goToCartButton2).click();
		}
		return new CartPage(driver);
	}
}
