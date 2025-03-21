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
    private By welcomeText = By.xpath("//*[@id=\'WelcomeContent\']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openLoginPage() throws InterruptedException {
    	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    	wait.until(ExpectedConditions.elementToBeClickable(signinButton)).click();
    	Thread.sleep(2000);
//        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void login(String user, String pass) throws InterruptedException {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        Thread.sleep(2000);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        Thread.sleep(2000);
        driver.findElement(loginButton).click();
    }
    public void displayWelcomeText() {
    	driver.findElement(welcomeText).getText();
    }
}
