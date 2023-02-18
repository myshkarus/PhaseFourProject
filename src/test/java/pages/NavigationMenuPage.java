package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NavigationMenuPage extends Page {

	public enum To {
		HOME, CATEGORIES, NOTIFICATIONS, ACCOUNT, CART;
	}

	private By homeButton = By.xpath("//android.widget.TextView[contains(@text,'Home')]");
	private By categoriesButton = By.xpath("//android.widget.TextView[contains(@text,'Categories')]");
	private By notificationsButton = By.xpath("//android.widget.TextView[contains(@text,'Notifications')]");
	private By accountButton = By.xpath("//android.widget.TextView[contains(@text,'Account')]");
	private By cartButton = By.xpath("//android.widget.TextView[@text='Cart']");
	
	public NavigationMenuPage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	@SuppressWarnings("unchecked")
	public <T> T navigate(To to) {
		switch (to) {
		case HOME:
			return (T) goToHome();
		case CATEGORIES:
			return (T) goToCategories();
		case NOTIFICATIONS:
			return (T) goToNotifications();
		case ACCOUNT:
			return (T) goToAccount();
		case CART:
			return (T) goToCart();
		default:
			return (T) goToHome();
		}
	}

	private HomePage goToHome() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(homeButton));
		driver.findElement(homeButton).click();
		return new HomePage(driver);
	}

	private CategoriesPage goToCategories() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(categoriesButton));
		driver.findElement(categoriesButton).click();
		return new CategoriesPage(driver);
	}

	private NotificationsPage goToNotifications() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(notificationsButton));
		driver.findElement(notificationsButton).click();
		return new NotificationsPage(driver);
	}

	private AccountPage goToAccount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountButton));
		driver.findElement(accountButton).click();
		return new AccountPage(driver);
	}

	private CartPage goToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartButton));
		driver.findElement(cartButton).click();
		return new CartPage(driver);
	}

}
