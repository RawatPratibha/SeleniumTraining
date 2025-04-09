package Training1;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 WebDriver driver = new FirefoxDriver();

	        // Browser settings
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	        // Launch site
	        driver.get("https://automationpractice.pl/");

	        // 1️⃣ XPath with contains() - search input
	        WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id,'search')]"));
	        searchBox.sendKeys("T-shirt");

	        // 2️⃣ XPath with starts-with() - search button
	        WebElement searchButton = driver.findElement(By.xpath("//button[starts-with(@name,'submit')]"));
	        searchButton.click();
	        
	        // 🔻 Scroll Down
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0, 500);"); // Scroll down 500px

	        // 3️⃣ XPath using text() - Click on a product link using visible text
	        WebElement productLink = driver.findElement(By.xpath("//a[text()='Faded Short Sleeve T-shirts']"));
	        productLink.click();

	        // 4️⃣ Hierarchical XPath (Parent > Child)
	        WebElement quantityBox = driver.findElement(By.xpath("//div[@class='product-information']//input[@id='quantity_wanted']"));
	        quantityBox.clear();
	        quantityBox.sendKeys("2");

	        // 5️⃣ XPath using multiple conditions
	        WebElement sizeDropdown = driver.findElement(By.xpath("//select[@id='group_1' and @name='group_1']"));
	        sizeDropdown.click();

	        // Wait and exit
	        try {
	            Thread.sleep(5000); // Just to see the result before quitting
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        driver.quit();
	    }
	}
