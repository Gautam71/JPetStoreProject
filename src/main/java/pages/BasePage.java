package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	
    public static void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://petstore.octoperf.com/");
        
    }
    
    public static WebDriver getDriver() {
    	if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    

    public static void tearDown() throws InterruptedException {
        	Thread.sleep(2000);
            driver.quit();
        
    }
}
