package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CartPage extends Page {

	private By removeButton = By.xpath("//android.widget.TextView[contains(@text, 'Remove')]");
	private By confirmationPopup = By.xpath("//*[contains(@text,'Successfully removed')]");
	private By emptyCartTitle = By.xpath("//android.widget.TextView[contains(@text,'Missing Cart items?')]");
	private By removeItemPopupTitle = By.xpath("//android.widget.TextView[contains(@text,'Remove Item')]");
	private By removeItemPopupButton = By.xpath("//android.widget.TextView[@text='Remove']");
	private By placeOrderButton = By.xpath("//android.widget.TextView[contains(@text, 'Place Order')]");

	public CartPage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	public OrderSummaryPage placeOrder() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(placeOrderButton));
		driver.findElement(placeOrderButton).click();
		return new OrderSummaryPage(driver);
	}

	public boolean IsEmpty() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartTitle));
			return driver.findElement(emptyCartTitle).isDisplayed();
		} catch (NoSuchElementException | TimeoutException e) {
			return false;
		}
	}

	public boolean ItemIsRemoved() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(confirmationPopup));
			return driver.findElement(confirmationPopup).isDisplayed();
		} catch (Exception NoSuchElementException) {
			return false;
		}
	}

	public CartPage removeItem() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(removeButton));
		driver.findElement(removeButton).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(removeItemPopupTitle));
		driver.findElement(removeItemPopupButton).click();
		return this;
	}

	public CartPage clearCart() {
		do {
			try {
				this.removeItem();
			} catch (Exception e) {
				System.out.println("The cart is empty");
				break;
			}
		} while (!this.IsEmpty());
		return this;
	}
}
