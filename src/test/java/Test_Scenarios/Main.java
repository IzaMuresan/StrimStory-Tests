package Test_Scenarios;

import Objects.*;

import Utils.BrowserManager;
import Utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Main {
	Environment env = new Environment();

	String url = env.PortalBaseUrl;
	String browser = env.browser;
	WebDriver driver = BrowserManager.getDriver(browser, url);

	@Test(priority = 1)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_01() throws InterruptedException {

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterValidCredentialsAndLogin();

	}
	@Test(priority = 2)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_02() throws InterruptedException {

		Library libraryPage = PageFactory.initElements(driver, Library.class);
		libraryPage.navigate_to_library_section();
		libraryPage.navigate_to_Biographies_in_library_section();
		libraryPage.add_book_to_favorites();

	}
	@Test(priority = 3)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_03() throws InterruptedException {

		Library libraryPage = PageFactory.initElements(driver, Library.class);
		libraryPage.navigate_to_library_section();
		libraryPage.navigate_to_Business_Section();
		libraryPage.add_book_to_favorites();

	}
	@Test(priority = 4)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_04() throws InterruptedException {

		Library libraryPage = PageFactory.initElements(driver, Library.class);
		libraryPage.navigate_to_library_section();
		libraryPage.navigate_to_Fiction_Section();
		libraryPage.add_book_to_favorites();

	}

	@Test(priority = 5)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_05() throws InterruptedException {

		Account accountPage = PageFactory.initElements(driver, Account.class);
		accountPage.NavigateToAccountPage();
	}
	@Test(priority = 6)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_06() throws InterruptedException {

		Account accountPage = PageFactory.initElements(driver, Account.class);
		accountPage.NavigateToInvoices();
	}
	@Test(priority = 7)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_07() throws InterruptedException {

		Account accountPage = PageFactory.initElements(driver, Account.class);
		accountPage.NavigateToPaymentMethods();
	}
	@Test(priority = 8)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_08() throws InterruptedException {

		Account accountPage = PageFactory.initElements(driver, Account.class);
		accountPage.NavigateToSubscription();
	}
	@Test(priority = 9)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_09() throws InterruptedException {

		Account accountPage = PageFactory.initElements(driver, Account.class);
		accountPage.NavigateToInvoices();
	}
	@Test(priority = 10)
	@Parameters({ "browser", "baseUrl" })
	void Test_Case_10() throws InterruptedException {

		Library libraryPage = PageFactory.initElements(driver, Library.class);
		libraryPage.change_language_romana();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	@AfterSuite

public void afterTestSuite() throws InterruptedException {
	//driver.quit();
}
}
