package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SearchPage {
	WebDriver driver;
	
	public By searchBox = By.name("keyword");
	public By searchButton = By.name("searchProducts");
//	public By searchResult = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr");
	public By searchResults = By.xpath("//table//a[contains(@href, 'Catalog.action?viewProduct=')]");
	public By productItemResult = By.xpath("//table//a[contains(@href, 'Catalog.action?viewItem=')]");
	public By priceOfProduct = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[6]/td");
	public By nameOfProduct = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[3]/td");
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeSearchBox(String animal) {
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(animal);
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public void selectFirstResultFound() throws InterruptedException{
		List<WebElement> result = driver.findElements(searchResults);
		if(!result.isEmpty()) {
			result.get(0).click();
			Thread.sleep(2000);
		}else {
			System.out.println("No result found!");
		}
	}
	
	public void selectFirstProductItem() throws InterruptedException {
		List<WebElement> result = driver.findElements(productItemResult);
		if(!result.isEmpty()) {
			result.get(0).click();
			Thread.sleep(2000);
		}else {
			System.out.println("No product item found!");
		}
	}
	
	public void addItemToCart() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\'Catalog\']/table/tbody/tr/td[5]"));
		if(!list.isEmpty()) {
			list.get(0).click();
		}
	}
	
	public void printPriceOfProduct() {
		String price = driver.findElement(priceOfProduct).getText();
		String productName = driver.findElement(nameOfProduct).getText();
		System.out.println("The price of " + productName + " is : " + price);
	}
}
