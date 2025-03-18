package stepDefinitions.registration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.RegistrationPage;

public class RegistrationSteps {
	
	WebDriver driver = BasePage.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);

	@Given("User is on the registration page")
	public void user_is_on_the_registration_page() {
		registrationPage.openRegistrationPage();
	}
	@When("User enters registration details")
	public void user_enters_registration_details() throws InterruptedException {
		registrationPage.fillRegistrationForm("gautam7102", "Gautam@71", "Gautam", "Bhatyani", "gautam@gmail.com", "1234567890", "153-D", "Cannaught Place", "Meerut", "UP", "250003", "India");
	}
	@When("User submits the registration form")
	public void user_submits_the_registration_form() {
		registrationPage.submitRegistration();
	}
	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
	    System.out.println("Registration Successful");
	}

	

}
