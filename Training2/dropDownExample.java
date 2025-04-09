package Training2;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		 //WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);"); // Scroll down 500px

        // Locate the classic select element
        WebElement oldStyleMenu = driver.findElement(By.id("oldSelectMenu"));

        // Create Select object
        Select select = new Select(oldStyleMenu);

        // Select by value
        select.selectByValue("2"); // Select "Blue"
        Thread.sleep(1000);

        // Select by visible text
        select.selectByVisibleText("Magenta");
        Thread.sleep(1000);

        // Select by index
        select.selectByIndex(6); // e.g., "Aqua"
        Thread.sleep(1000);

        // Print selected option
        WebElement selected = select.getFirstSelectedOption();
        System.out.println("Selected color: " + selected.getText());

        // List all options
        System.out.println("All available colors:");
        List<WebElement> allOptions = select.getOptions();
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
    }
}