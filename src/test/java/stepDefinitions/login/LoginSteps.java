package stepDefinitions.login;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.LoginPage;

public class LoginSteps {
	
	WebDriver driver = BasePage.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    
	@Given("User is on the login page")
	public void user_is_on_the_login_page() {
		loginPage.openLoginPage();
	}
	@When("User logs in with {string} and {string}")
	public void user_logs_in_with_and(String user, String pass) {
		loginPage.login(user, pass);
	}
	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    System.out.println("Successfully logged in!");
	}

		

}
