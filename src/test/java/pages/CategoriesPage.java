package pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CategoriesPage {
	AndroidDriver<MobileElement> driver;
	Wait<WebDriver> wait;

	public CategoriesPage(AndroidDriver<MobileElement> basedriver) {
		this.driver = basedriver;
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(3000))
				.pollingEvery(Duration.ofMillis(3000)).ignoring(NoSuchElementException.class)
				.ignoring(TimeoutException.class);
	}
}
