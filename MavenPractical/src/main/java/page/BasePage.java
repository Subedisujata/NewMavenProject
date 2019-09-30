package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage{
public static void waitforelement(WebElement element , WebDriver driver) {
	WebDriverWait wait=new WebDriverWait(driver,60);
	wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
}