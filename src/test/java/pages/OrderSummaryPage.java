package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class OrderSummaryPage extends Page {

	private By pageTitle = By.id("com.flipkart.android:id/title_action_bar");

	public OrderSummaryPage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	public String getTitle() {
		String title;
		wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
		title = driver.findElement(pageTitle).getText();
		return title;
	}
}
