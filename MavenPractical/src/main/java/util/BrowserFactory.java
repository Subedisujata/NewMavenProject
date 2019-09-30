package util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.BasePage;



public class BrowserFactory extends BasePage{

	public static WebDriver startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://techfios.com/test/107/");
		return driver;	
	}
}

