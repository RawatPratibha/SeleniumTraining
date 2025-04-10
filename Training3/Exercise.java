package Training3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Exercise {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();

	        // Open BrowserStack homepage
	        driver.get("https://www.browserstack.com/");
	        Thread.sleep(3000); // Wait for page to load
       

	        // Find the "Get Started Free" button
	        WebElement getStartedBtn = driver.findElement(By.xpath("//a[contains(text(),'Get started free')]"));

	        // Perform click and hold using Actions
	        Actions actions = new Actions(driver);
	        actions.clickAndHold(getStartedBtn).pause(2000).build().perform();

	        // Use Robot class to simulate key press (e.g., press Tab key)
	        Robot robot = new Robot();
	        robot.delay(1000);

	        // Simulate pressing the TAB key after click-hold
	        robot.keyPress(KeyEvent.VK_TAB);
	        robot.keyRelease(KeyEvent.VK_TAB);

	        System.out.println(" Click and hold performed on 'Get Started Free' and TAB key pressed via Robot.");

	        Thread.sleep(3000); // Observe the effect

	        // Cleanup
	        driver.quit();
	    }
	}

