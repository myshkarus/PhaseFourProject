package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.OrderSummaryPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CatalogPage;

public class FlipkartTest extends BaseClass {

	@Test
	public void placeOrder() throws InterruptedException {
		
		// 1. Type ‘mobile’ in the search-box
		HomePage home = new HomePage(driver);
		CatalogPage catalog = home.startSearch().searchForItem("mobile");

		// 2. Click on the first search result
		ProductPage product = catalog.selectItem(1);

		// 3. Click on ‘Add to cart’ button; a long pause is possible
		product.addToCart();

		// 4. Click on ‘Go to cart’ button; a long pause is possible
		CartPage cart = product.goToCart();

		// 5. Click on ‘Place Order’ button
		OrderSummaryPage orderSummary = cart.placeOrder();

		// 6. Verify you see ‘Order Summary’ as heading of the activity
		String expectedTitle = "Order Summary";
		String actualTitle = orderSummary.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
}
