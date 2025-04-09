package Training1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
    	//WebDriver driver = new ChromeDriver();
	    //WebDriver driver = new EdgeDriver();
	
	WebDriver driver = new FirefoxDriver();
			
	Thread.sleep(3000);
	
	driver.get("https://www.saucedemo.com/");

	}

}
