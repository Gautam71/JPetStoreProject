package stepDefinitions.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.SearchPage;

public class SearchSteps {
	WebDriver driver;
	SearchPage searchPage;
	List<WebElement> list;
	
	@Given("User is on the HomePage")
	public void user_is_on_the_home_page() {
		BasePage.initializeBrowser("chrome");
		
	    driver = BasePage.getDriver();
	    
	    searchPage = new SearchPage(driver);
	    driver.findElement(By.linkText("Enter the Store")).click();
	    driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	    
	}
	@When("User search for {string}")
	public void user_search_for(String animal) {
	    searchPage.typeSearchBox(animal);
	    searchPage.clickSearchButton();
	}
	@Then("User selects the first pet from search results")
	public void user_selects_the_first_pet_from_search_results() throws InterruptedException {
		searchPage.selectFirstResultFound();
	    
	}
	@Then("User selects a product item")
	public void user_selects_a_product_item() throws InterruptedException {
	  searchPage.selectFirstProductItem();
	}
	@Then("Displays the price of product")
	public void displays_the_price_of_product() {
	    searchPage.printPriceOfProduct();
	}

	
}
