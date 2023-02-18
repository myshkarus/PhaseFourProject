package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends Page {

	private By searchField = By.xpath(
			"//android.widget.TextView[contains(@text,'Brand')]//following-sibling::android.view.ViewGroup[2]//android.widget.TextView");

	public HomePage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	public CatalogPage startSearch() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchField));
		driver.findElement(searchField).click();
		return new CatalogPage(driver);
	}
}
