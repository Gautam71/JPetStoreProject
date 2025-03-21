package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	 WebDriver driver;
	 WebDriverWait wait;

	    // Locators
	    private By registerLink = By.linkText("Register Now!");
	    private By username = By.name("username");
	    private By password = By.name("password");
	    private By confirmPassword = By.name("repeatedPassword");
	    private By firstName = By.name("account.firstName");
	    private By lastName = By.name("account.lastName");
	    private By email = By.name("account.email");
	    private By phone = By.name("account.phone");
	    private By registerButton = By.name("newAccount");
	    private By address1 = By.name("account.address1");
	    private By address2 = By.name("account.address2");
	    private By zipcode = By.name("account.zip");
	    private By city = By.name("account.city");
	    private By country = By.name("account.country");
	    private By state = By.name("account.state");
	    private By languagePreference = By.name("account.languagePreference");
//	    private By category = By.name("account.favouriteCategoryId");
	    private By myList = By.name("account.listOption");
	    private By myBanner = By.name("account.bannerOption");

	    
	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void openRegistrationPage() {
	    	driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
	    }

	    public void fillRegistrationForm(String user, String pass, String fName, String lName, String mail, String phoneNo, String add1, String add2, String cityName, String stateName, String zip, String countryName) throws InterruptedException {
	        driver.findElement(username).sendKeys(user);
	        driver.findElement(password).sendKeys(pass);
	        driver.findElement(confirmPassword).sendKeys(pass);
	        driver.findElement(firstName).sendKeys(fName);
	        driver.findElement(lastName).sendKeys(lName);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(phone).sendKeys(phoneNo);
	        driver.findElement(address1).sendKeys(add1);
	        driver.findElement(address2).sendKeys(add2);
	        driver.findElement(city).sendKeys(cityName);
	        driver.findElement(state).sendKeys(stateName);
	        driver.findElement(zipcode).sendKeys(zip);
	        driver.findElement(country).sendKeys(countryName);
	        Select s1 = new Select(driver.findElement(languagePreference));
	        s1.selectByVisibleText("japanese");
	        
//	        Select s2 = new Select(driver.findElement(category));
//	        s1.selectByVisibleText("BIRDS");
	        driver.findElement(myList).click();
	        driver.findElement(myBanner).click();
	        Thread.sleep(2000);
	        
	    }

	    public void submitRegistration() throws InterruptedException {
	        driver.findElement(registerButton).click();
	        Thread.sleep(2000);
	    }
}
