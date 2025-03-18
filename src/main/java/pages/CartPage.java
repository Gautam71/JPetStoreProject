package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	SearchPage searchPage;
	
	private By checkoutButton = By.xpath("//a[contains(text(),'Proceed to Checkout')]");
	private By cartItemsLocator = By.xpath("//table[@id='Cart']//td[1]");
	private By quantityField = By.xpath("//*[@id=\'Cart\']/form/table/tbody/tr[4]/td[5]/input");
//	//*[@id="Cart"]/form/table/tbody/tr[2]/td[5]/input //*[@id="Cart"]/form/table/tbody/tr[3]/td[5]/input
    private By updateButton = By.xpath("//*[@id=\'Cart\']/form/table/tbody/tr[5]/td[1]/input");
//    //*[@id="Cart"]/form/table/tbody/tr[5]/td[1]/input
    private By removeButton = By.xpath("//*[@id=\'Cart\']/form/table/tbody/tr[2]/td[8]/a");
    private By signin = By.xpath("//*[@id=\'MenuContent\']/a[2]");
    private By username = By.name("username");
    private By password = By.name("password");
    private By signon = By.name("signon");
    private By cartlogo = By.xpath("//*[@id=\'MenuContent\']/a[1]/img");
    private By menuItem = By.xpath("//*[@id=\'QuickLinks\']/a[1]/img");
    private By item = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a");
    private By addtocart = By.xpath("//*[@id=\'Catalog\']/table/tbody/tr[2]/td[5]/a");
    private By removeLink = By.xpath("//a[@href='/actions/Cart.action?removeItemFromCart=&workingItemId=']");

//    private By cartIcon = By.xpath("//*[@id=\"MenuContent\"]/a[1]/img");

	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		searchPage = new SearchPage(driver);
	}
	
	public void searchAndAddProductToCart(String animal) throws InterruptedException {
		searchPage.typeSearchBox(animal);
		searchPage.clickSearchButton();
		searchPage.selectFirstResultFound();
		searchPage.addItemToCart();
		
	}
	
	public boolean isProductInCart(String name) {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\'Cart\']/form/table/tbody/tr/td[3]"));
		List<String> nameOfProducts = new ArrayList<>();
		for(WebElement products : list) {
			nameOfProducts.add(products.getText());
		}
		for(String names : nameOfProducts) {
			if(names.equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
		
	}
	
	public void takeToCartPage() throws InterruptedException {
		driver.findElement(cartlogo).click();
		Thread.sleep(2000);
	}
	
	public void updateQuantity(int quantity) throws InterruptedException {
		driver.findElement(quantityField).clear();
		Thread.sleep(2000);
		driver.findElement(quantityField).sendKeys(String.valueOf(quantity));
		Thread.sleep(2000);
		driver.findElement(updateButton).click();
	}
	
	public void removeProduct(String productId) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[@href='/actions/Cart.action?removeItemFromCart=&workingItemId=" + productId + "']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\'Cart\']/form/table/tbody/tr[4]/td[1]/input")).click();
		//*[@id="Cart"]/form/table/tbody/tr[3]/td[1]/input
		
	}
	
	
	public boolean isQuantityUpdated() {
		return driver.findElement(quantityField).getAttribute("value").equals("2");
	}
	public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    // Method to verify checkout page is displayed
    public boolean isCheckoutPageDisplayed() {
        return driver.getCurrentUrl().contains("Order.action");
    }
    
    
}
	
	