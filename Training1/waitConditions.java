package Training1;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitConditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new FirefoxDriver();

	        // ✅ 1. Implicit Wait — applies globally
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();

	        // Open test site
	        driver.get("https://automationpractice.pl/");

	        // Use Implicit Wait — search input will be waited for up to 10 sec
	        WebElement searchBox = driver.findElement(By.id("search_query_top"));
	        searchBox.sendKeys("Dress");

	        // ✅ 2. Explicit Wait — wait for specific condition on element
	        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement searchButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.name("submit_search")));
	        searchButton.click();

	        // ✅ 3. Fluent Wait — wait with polling & custom handling
	        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
	                .withTimeout(Duration.ofSeconds(20))        // total time to wait
	                .pollingEvery(Duration.ofSeconds(2))        // check every 2 seconds
	                .ignoring(NoSuchElementException.class);    // ignore if element is not found
 
	        WebElement product = fluentWait.until(new Function<WebDriver, WebElement>() {       	
	            public WebElement apply(WebDriver driver) {
	                WebElement element = driver.findElement(By.xpath("//a[@class='product-name' and contains(text(),'Dress')]"));
	                if (element.isDisplayed()) {
	                    return element;
	                }
	                return null;
	            }
	        });

	        // Click product after fluent wait
	        product.click();

	        // Wait just to see result
	        try {
	            Thread.sleep(3000);
	        } catch (Exception e) {}

	        driver.quit();
	    }
	}
