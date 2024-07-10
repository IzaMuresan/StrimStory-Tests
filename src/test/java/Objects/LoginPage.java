package Objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Utils.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class LoginPage {
	Environment env = new Environment();


	WebDriver driver;
	
	@FindBy(how = How.ID, using = "inputEmail")
	private WebElement username_field;

	@FindBy(how = How.ID, using = "inputPassw")
	private WebElement password_field;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Login']")
	private WebElement login_button;

	@FindBy(how = How.ID, using = "consentBtn")
	private WebElement consent_button;




	public void enterValidCredentialsAndLogin() throws InterruptedException {
		consent_button.click();
		username_field.clear();
		username_field.sendKeys("izabela.muresan@gmail.com");
		Thread.sleep(1000);

		password_field.clear();
		password_field.sendKeys("qwerty123!");
		Thread.sleep(1000);
		Reporter.log("Login Credentials are added Successfully ",true);

		login_button.click();
		Thread.sleep(1000);
		Reporter.log("User is logged-in Successfully ",true);
		
	}


	public void waiting() throws InterruptedException {
		Thread.sleep(2000);
	}

}
