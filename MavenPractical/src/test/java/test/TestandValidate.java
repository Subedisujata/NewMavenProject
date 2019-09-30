package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.BasePage;
import page.Nsspage;
import util.BrowserFactory;

public class TestandValidate extends BasePage {
	WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver = BrowserFactory.startBrowser();
		Thread.sleep(2000);
	}

	@Test
	void user_should_be_able_to_add_category() throws InterruptedException {
		Nsspage getelements = PageFactory.initElements(driver, Nsspage.class);
		getelements.addcategory();
		Thread.sleep(3000);
		waitforelement(getelements.Newaddedcategory, driver);
		String Titleofcategory = getelements.Newaddedcategory.getText();
		System.out.println(Titleofcategory);
		String Expectedtitle = ("Check Category");
		Assert.assertEquals(Titleofcategory, Expectedtitle, "New added title not displayed");

		Nsspage warning = PageFactory.initElements(driver, Nsspage.class);
		String Actualwarning = warning.getwarningtext();
		System.out.println(Actualwarning);
		String ExpectedWarning = "The category you want to add already exists: Check Category.";
		Assert.assertTrue(Actualwarning.contains(ExpectedWarning), "duplicates allowed");

		Nsspage getmonths = PageFactory.initElements(driver, Nsspage.class);
		getmonths.goingbacktomainpage();
		getmonths.monthsdropdown();
		getmonths.monthscheck();

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}
}