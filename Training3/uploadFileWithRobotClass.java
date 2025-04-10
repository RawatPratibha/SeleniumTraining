package Training3;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class uploadFileWithRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub

		 WebDriver driver = new FirefoxDriver();

	      //  driver.get("https://demoqa.com/browser-windows");
	       // driver.manage().window().maximize();
		
	     // Navigate to a sample file upload page
	        driver.get("https://demo.guru99.com/test/upload/");
	        Thread.sleep(5000);
	        

	        // Click on the "Choose File" button to open OS dialog
	       WebElement ele =driver.findElement(By.id("uploadfile_0"));
	        
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", ele);
	        

	        // Pause for file dialog to open
	        Thread.sleep(2000);

	        // Full path to the file to be uploaded	        
	        String filePath = "C:\\Users\\Admin\\Documents\\FileUploadTest.txt";

	        // Copy file path to clipboard
	        StringSelection selection = new StringSelection(filePath);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Use Robot to paste and hit Enter
	        Robot robot = new Robot();
	        robot.delay(1000);

	        // Ctrl + V
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);

	        // Press Enter
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	        // Wait a bit to complete upload
	        Thread.sleep(2000);

	        // Accept checkbox and click submit
	        driver.findElement(By.id("terms")).click();
	        driver.findElement(By.id("submitbutton")).click();

	        // Done
	        System.out.println("File uploaded successfully!");

	        Thread.sleep(3000);
	        driver.quit();
	    }
	}

