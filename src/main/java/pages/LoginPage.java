package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	WebDriver driver;
    WebDriverWait wait;

    private By signinButton = By.linkText("Sign In");
//    private By loginLink = By.name("signon");
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.name("signon");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() {
    	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    	wait.until(ExpectedConditions.elementToBeClickable(signinButton)).click();
//        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
