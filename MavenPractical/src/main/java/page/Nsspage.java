package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class Nsspage {
	WebDriver driver;

	public Nsspage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']")
	WebElement MessageBox;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']")
	WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Check Category')]")
	public WebElement Newaddedcategory;
	@FindBy(how = How.XPATH, using = "/html/body")
	WebElement Warning;
	@FindBy(how = How.LINK_TEXT, using = "Nevermind")
	WebElement buttontogoback;
	@FindBy(how = How.CSS, using = "select[name='due_month']")
	WebElement monthsmenu;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']/descendant::option")
	List<WebElement> months;

	public void addcategory() throws InterruptedException {
		MessageBox.sendKeys("Check Category");
		Thread.sleep(2000);
		AddButton.click();
	}

	public String checkingcategory() {
		String newaddedcategory = Newaddedcategory.getText().toString();
		return newaddedcategory;
	}

	public String getwarningtext() {
		String Text = Warning.getText();
		return Text;
	}

	public void goingbacktomainpage() throws InterruptedException {
		buttontogoback.click();
	}

	public void monthsdropdown() throws InterruptedException {
		monthsmenu.click();
		Thread.sleep(1000);
	}

	public void monthscheck() {
		String[] expectedmonths = { "None", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct",
				"Nov", "Dec" };
		if (expectedmonths.length != months.size()) {
			System.out.println("Fail, wrong number of elements found");
		}
		for (int i = 0; i < months.size(); i++) {
			String ActualMounthsPresent = months.get(i).getText();
			if (ActualMounthsPresent.equals(expectedmonths[i])) {
				System.out.println("passed on: " + ActualMounthsPresent);
			} else {
				System.out.println("failed on: " + ActualMounthsPresent);
			}
		}
	}
}