package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.CartPage;
import pages.NavigationMenuPage;
import pages.NavigationMenuPage.To;

public class BaseClass {

	AndroidDriver<MobileElement> driver;

	@BeforeTest
	public void launchApplication() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("appPackage", "com.flipkart.android");
		cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		cap.setCapability("noReset", true);
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}

	@BeforeMethod
	public void clearCart() {
		NavigationMenuPage nm = new NavigationMenuPage(driver);
		CartPage cart = nm.navigate(To.CART);

		boolean isEmpty = cart.IsEmpty();
		if (!isEmpty) {
			cart.clearCart();
		}

		nm.navigate(To.HOME);
	}

	@AfterTest
	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}
}
