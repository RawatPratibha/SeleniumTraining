package Training2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        // Create JavaScriptExecutor reference
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Set value to input field using JS
        js.executeScript("document.getElementById('userName').value='John Doe';");
        js.executeScript("document.getElementById('userEmail').value='john@example.com';");

        // 2. Scroll down by 300 pixels
        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(1000);

        // 3. Scroll to a specific element (Submit button)
        WebElement submitBtn = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);", submitBtn);

        Thread.sleep(1000);

        // 4. Click element using JS
        js.executeScript("arguments[0].click();", submitBtn);

        Thread.sleep(2000);

        // 5. Get page title using JS
        String title = (String) js.executeScript("return document.title;");
        System.out.println("Page Title is: " + title);

        // 6. Highlight element with JS (just for visual demo)
        WebElement nameField = driver.findElement(By.id("userName"));
        js.executeScript("arguments[0].style.border='3px solid red'", nameField);

        Thread.sleep(2000);

        driver.quit();
    }
}