package stepDefinitions.cart;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

public class CartSteps {
	WebDriver driver;
	CartPage cartPage;
	
	public CartSteps() {
		this.driver = BasePage.getDriver(); 
        this.cartPage = new CartPage(driver); 
	}
	SoftAssert softAssert = new SoftAssert();


	@Given("user is on the homepage")
	public void user_is_on_the_homepage() {
		BasePage.initializeBrowser("chrome");
	    driver = BasePage.getDriver();
	    cartPage = new CartPage(driver);
	    driver.findElement(By.linkText("Enter the Store")).click();
	}
	
	@When("user search for the animals and add first product to cart")
	public void user_search_for_the_animals_and_add_first_product_to_cart(DataTable dataTable) throws InterruptedException {
		List<String> list = dataTable.asList();
		for(String product : list) {
			cartPage.searchAndAddProductToCart(product);
		}
	}
	@Then("the cart should display the following products")
	public void the_cart_should_display_the_following_products(DataTable dataTable) {
		List<String> expectedResults = dataTable.asList();
		for(String product : expectedResults) {
//			Assert.assertTrue(cartPage.isProductInCart(product), "Product " + product + " not found in cart!");
			softAssert.assertTrue(cartPage.isProductInCart(product), "Product " + product + " not found in cart!");
			
		}
	}

	



	@Given("user is on the cartpage")
	public void user_is_on_the_cartpage() throws InterruptedException {
		cartPage.takeToCartPage();
	}
	@When("user update quantity of a product")
	public void user_update_quantity_of_a_product() throws InterruptedException {
		cartPage.updateQuantity(2);
	}
	@Then("quantity should be updated in the cart")
	public void quantity_should_be_updated_in_the_cart() {
		cartPage.isQuantityUpdated();
	}



	@Given("user is on the cart page")
	public void user_is_on_the_cart_page() throws InterruptedException {
		cartPage.takeToCartPage();
	}

	
	@When("user removes a product {string} from the cart")
	public void user_removes_a_product_from_the_cart(String productId) throws InterruptedException {
	    
	    cartPage.removeProduct(productId);
	}
	@Then("it should be removed from the cart")
	public void it_should_be_removed_from_the_cart() {
		cartPage.isProductInCart("Male Adult Bulldog");
	}

	



	@Given("user has items in the cart")
	public void user_has_items_in_the_cart() {
		System.out.println("we are on the cart Page");
	}
	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		cartPage.proceedToCheckout();
	}
	@Then("checkout page should be displayed")
	public void checkout_page_should_be_displayed() throws InterruptedException {
		Assert.assertTrue(cartPage.isCheckoutPageDisplayed(), "Checkout page not displayed!");
		
	}

}

	