package Training2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html"); // Sample page

        Actions actions = new Actions(driver);

        // 1. Move to element and click
        WebElement rightClickBtn = driver.findElement(By.cssSelector(".context-menu-one"));
        actions.moveToElement(rightClickBtn).click().perform();

        // 2. Right-click (context click)
        actions.contextClick(rightClickBtn).perform();
        Thread.sleep(2000);

        // 3. Double-click
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
        actions.doubleClick(doubleClickBtn).perform();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // 4. Drag and drop (another example page)
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0); // Switch to iframe

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

        // 5. Send keys using Actions
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        actions.moveToElement(searchBox).click()
               .sendKeys("Selenium WebDriver")
               .sendKeys(Keys.ENTER)
               .build().perform();

        Thread.sleep(3000);
        driver.quit();
    }
}



