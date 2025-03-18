package stepDefinitions.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BasePage;
import pages.HomePage;

public class HomeSteps {
	WebDriver driver;
	HomePage homePage;
	

	@Given("user is on HomePage")
	public void user_is_on_home_page() throws InterruptedException {
		BasePage.initializeBrowser("chrome");
		driver = BasePage.getDriver();
		homePage = new HomePage(driver);
	    driver.findElement(By.linkText("Enter the Store")).click();
	    Thread.sleep(3000);
	    }

	

	@Then("Verify HomePage title is {string}")
	public void verify_home_page_title_is(String expectedTitle) {
	   String actualTitle = homePage.getHomePageTitle();
	   Assert.assertEquals(actualTitle , expectedTitle);
	}


	@Then("Verify HomePage link")
	public void verify_home_page_link() {
	    String expectedURL = "https://petstore.octoperf.com/actions/Catalog.action";
	    String actualURL = homePage.getURL();
	    Assert.assertEquals(expectedURL , actualURL);
	}

}
