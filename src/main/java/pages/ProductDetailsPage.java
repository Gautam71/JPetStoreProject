package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By productImage = (By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[1]/td/img"));
	By productTitle = (By.xpath("//*[@id='Catalog']/table/tbody/tr[3]/td"));
	By productDescription = (By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[1]"));
	By productPrice = (By.xpath("//*[@id='Catalog']/table/tbody/tr[6]"));
	By productAvailability = (By.xpath("//*[@id='Catalog']/table/tbody/tr[5]"));
	By addToCartButton = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[7]/td/a");
	By itemButton = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[2]/td[1]/a");
	
	public String getProductTitle() {
        return driver.findElement(productTitle).getText();
    }

    public String getProductDescription() {
        return driver.findElement(productDescription).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public boolean isProductImageDisplayed() {
        return driver.findElement(productImage).isDisplayed();
    }

    public String getProductAvailability() {
        return driver.findElement(productAvailability).getText();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
    public void clickItem() {
    	driver.findElement(itemButton).click();
    }
   
}
