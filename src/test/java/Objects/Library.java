package Objects;

import Utils.Environment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Library {
    Environment env = new Environment();
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Library']")
    private WebElement library_button;

    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Biographies, Memoirs and Diaries']")
    private WebElement Biographies_Section;

    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Business & Economics']")
    private WebElement Business_Section;

    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Fiction']")
    private WebElement Fiction_Section;

    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Meditation']")
    private WebElement Meditation_Section;

    @FindBy(how = How.XPATH, using = "//p[normalize-space()='Education']")
    private WebElement Education_Section;

    @FindBy(how = How.XPATH, using = "//a[@id='navbarDropdownMenuLink']")
    private WebElement Language_in_Navbar;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Română')]")
    private WebElement Romanian_Language_in_Navbar;


    @FindBy(how = How.XPATH, using = "//i[@class='bi bi-heart-fill']")
    private WebElement like_button;

    @FindBy(how = How.XPATH, using = "(//i[@class='bi bi-heart'])[1]")
    private WebElement Dislike_button;



    @FindBy(how = How.XPATH, using = "//input[@value='Apply']")
    private WebElement apply_button;

    public Library(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigate_to_library_section() throws InterruptedException {
        library_button.click();
        Thread.sleep(1000);
        Reporter.log("User is navigated to Library Section Successfully ", true);
    }
    public void change_language_romana() throws InterruptedException {
        Language_in_Navbar.click();
        Thread.sleep(1000);
        Romanian_Language_in_Navbar.click();
        Reporter.log("User has Changed the Language to Romana Successfully ", true);
    }

    public void navigate_to_Biographies_in_library_section() throws InterruptedException {
        Biographies_Section.click();
        Thread.sleep(1000);
        Reporter.log("User is navigated to Biographies, Memoirs and Diaries Section Successfully ", true);
    }

    public void navigate_to_Business_Section() throws InterruptedException {
        Business_Section.click();
        Thread.sleep(1000);

    }
    public void navigate_to_Fiction_Section() throws InterruptedException {
        Fiction_Section.click();
        Thread.sleep(1000);
        Reporter.log("User is navigated to Fiction Section Successfully ", true);
    }
    public void navigate_to_Meditation_Section() throws InterruptedException {
        Meditation_Section.click();
        Thread.sleep(1000);
        Reporter.log("User is navigated to Meditation Section Successfully ", true);
    }

    public void add_book_to_favorites() throws InterruptedException {
        try {
            if (like_button.isDisplayed()) {
                // Do nothing as the like_button is already visible
            } else {
                Dislike_button.click();
            }
        } catch (NoSuchElementException e) {
            try {
                Dislike_button.click();
            } catch (NoSuchElementException ex) {
                Reporter.log("Neither like button nor dislike button found", true);
                return;  // Exit the method if neither button is found
            }
        }

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", apply_button);
        Reporter.log("Added to favorites Successfully", true);
    }



    public void waiting() throws InterruptedException {
        Thread.sleep(2000);
    }
}
