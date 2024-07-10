package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class Account {
    static WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;

    }
    @FindBy(how = How.XPATH, using = "//img[@alt='StrimStory']")
    private WebElement logo_icon;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Account details']")
    private WebElement Account_Details;
    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Subscription']")
    private WebElement Subscription;
    @FindBy(how = How.XPATH,using = "//span[normalize-space()='Payment methods']")
    private WebElement Payment_methods;
    @FindBy(how = How.XPATH,using = "//span[normalize-space()='Invoices']")
    private WebElement Invoices;
    @FindBy(how = How.XPATH,using = "//a[normalize-space()='Account']")
    private WebElement Account_Button;


    public void NavigateToAccountPage() throws InterruptedException {
        Thread.sleep(8000);
        Account_Button.click();
        Thread.sleep(3000);
        Reporter.log("User has been navigated to Account Page....  ", true);
    }
    public void NavigateToSubscription() throws InterruptedException {
        Thread.sleep(2000);
        Subscription.click();

        Reporter.log("User has been navigated to Subscription Section....  ", true);
    }
    public void NavigateToPaymentMethods() throws InterruptedException {
        Thread.sleep(2000);
        Payment_methods.click();
        Reporter.log("User has been navigated to Payment Methods Section....  ", true);
    }
    public void NavigateToInvoices() throws InterruptedException {
        Thread.sleep(2000);
        Invoices.click();
        Reporter.log("User has been navigated to Invoices Section....  ", true);
    }



}
