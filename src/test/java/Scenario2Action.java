import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Scenario2Action {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void verifySubmitCreateAccount() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        //Click on "Create an Account "
        WebElement menuBags = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]"));
        menuBags.click();

        //fill first name
        WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys("Le Trung");

        //fill last name
        WebElement inputLastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys("Hieu");

        //fill email
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys("lehieuman13@gmail.com");

        //fill email
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys("1234567Abx");

        WebElement inputPasswordConfirmation = driver.findElement(By.xpath("//input[@name='password_confirmation']"));
        inputPasswordConfirmation.sendKeys("1234567Abx");

        //click submit
        WebElement btnSubmit = driver.findElement(By.xpath("//button[@title='Create an Account']"));
        btnSubmit.click();

        //wait for form sent success
        //verify "Welcome, !"
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//li[@class='greet welcome']")),
                "Welcome,"));
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
