package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver; 
	
	 public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public String getHomePageTitle() {
	        return driver.getTitle();
	    }
	    
	 public String getURL() {
		 return driver.getCurrentUrl();
	 }
}
