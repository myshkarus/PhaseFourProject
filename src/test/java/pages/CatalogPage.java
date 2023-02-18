package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class CatalogPage extends Page {

	String itemName = "";
	private By searchField = By.xpath("//android.widget.EditText");
	private String item = "//android.widget.ScrollView//android.view.ViewGroup//android.view.ViewGroup//android.view.ViewGroup";

	public CatalogPage(AndroidDriver<MobileElement> basedriver) {
		super(basedriver);
	}

	public CatalogPage searchForItem(String itemToSearch) {
		itemName = itemToSearch;
		driver.hideKeyboard();
		driver.findElement(searchField).sendKeys(itemToSearch);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		return this;
	}

	public ProductPage selectItem(int position) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(" + item + ")[" + position + "]")));
		driver.findElement(By.xpath("(" + item + ")[" + position + "]")).click();
		return new ProductPage(driver);
	}

}
