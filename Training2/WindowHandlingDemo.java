package Training2;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WindowHandlingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();

	        driver.get("https://demoqa.com/browser-windows");
	        driver.manage().window().maximize();

	        // Store the parent window handle
	        String parentWindow = driver.getWindowHandle();
	        System.out.println("Parent Window "+parentWindow);

	        // Click button to open a new window
	        driver.findElement(By.id("windowButton")).click();

	        // Get all window handles
	        Set<String> allWindows = driver.getWindowHandles();

	        // Loop through handles
	        for (String windowHandle : allWindows) {
	            if (!windowHandle.equals(parentWindow)) {
	                driver.switchTo().window(windowHandle); // Switch to new window
	                System.out.println("Child Window Title: " + driver.getTitle());
	                Thread.sleep(2000);
	                driver.close(); // Close child window
	            }
	        }

	        // Switch back to parent window
	        driver.switchTo().window(parentWindow);
	        System.out.println("Back to Parent Window: " + driver.getTitle());

	        driver.quit();
	    }
	}