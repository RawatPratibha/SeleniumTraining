package Training2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class iFrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new FirefoxDriver();
		driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        // Switch to frame by ID
        driver.switchTo().frame("frame1");

        // Interact with element inside the frame
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        System.out.println("Text inside frame: " + heading.getText());

        // Switch back to the main content
        driver.switchTo().defaultContent();

        driver.quit();
		
	}

}
