package stepDefinitions.details;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.ProductDetailsPage;

public class ProductsDetails {
	
	WebDriver driver = BasePage.getDriver();
	ProductDetailsPage productPage = new ProductDetailsPage(driver);
	SoftAssert softAssert = new SoftAssert();
	
	@Given("user is on the product page for {string}")
	public void user_is_on_the_product_page_for(String productId) {
		driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=" + productId);
		productPage.clickItem();
		
	}
	@Then("product title should be {string}")
	public void product_title_should_be(String expectedTitle) {
		Assert.assertEquals(productPage.getProductTitle(), expectedTitle);
	}
	@Then("product description should be visible")
	public void product_description_should_be_visible() {
		Assert.assertFalse(productPage.getProductDescription().isEmpty());
	   
	}
	@Then("product price should be displayed")
	public void product_price_should_be_displayed() {
		Assert.assertFalse(productPage.getProductPrice().isEmpty());
	}
	@Then("product image should be present")
	public void product_image_should_be_present() {
		Assert.assertTrue(productPage.isProductImageDisplayed());
	}
	@Then("product availability should be {string}")
	public void product_availability_should_be(String result) {
		String output = productPage.getProductAvailability();
	    if(!output.contains(result) || !output.contains("Back Ordered.")) {
	    	softAssert.fail();
	    }
	}
	@Then("add the product to cart")
	public void add_the_product_to_cart() {
		productPage.addToCart();
	}
	@Then("check if user is directed to cart page {string}")
	public void check_if_user_is_directed_to_cart_page(String expected) throws InterruptedException {
	    String currentURL = driver.getCurrentUrl();
	    Assert.assertEquals(currentURL, expected);
	    
	}

		
}
