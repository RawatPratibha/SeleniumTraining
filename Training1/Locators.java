package Training1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

	     // ✅ Maximize window and set implicit wait
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	     // ✅ Open Practice Automation Website
	     driver.get("https://automationpractice.pl/");

	     // 1️⃣ Locate search box using ID and enter text
	     WebElement searchBox = driver.findElement(By.id("search_query_top"));
	     searchBox.sendKeys("Dress");
	    

	     // 2️⃣ Locate Search Button using NAME and click it
	     WebElement searchButton = driver.findElement(By.name("submit_search"));
	     searchButton.click();

	     // 3️⃣ Locate first product using CLASS NAME and click
	     WebElement firstProduct = driver.findElement(By.className("product_img_link"));
	     firstProduct.click();

	  // 4️⃣ Locate "Add to Cart" button using TAG NAME and click
	     WebElement addToCartButton = driver.findElement(By.tagName("button"));
	     addToCartButton.click();
	     
	     // 5️⃣ Locate "Contact us" link using LINK TEXT and click
	     WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
	     contactUsLink.click();
	     
	  // 6️⃣ Locate "Send" button using PARTIAL LINK TEXT (not full name) and click
	     WebElement sendButton = driver.findElement(By.partialLinkText("Send"));
	     sendButton.click();
	     
	  // 7️⃣ Locate Email input field using CSS SELECTOR and enter text
	     WebElement emailField = driver.findElement(By.cssSelector("input#email"));
	     emailField.sendKeys("test@example.com");

	     // 8️⃣ Locate Message TextBox using XPATH and enter text
	     WebElement messageBox = driver.findElement(By.xpath("//textarea[@id='message']"));
	     messageBox.sendKeys("Hello, I have an issue.");
	     
	     // ✅ Wait for 5 seconds to observe actions
	     try {
	         Thread.sleep(5000);
	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     }

	    // Close the browser
	   // driver.quit();
	}
	}

