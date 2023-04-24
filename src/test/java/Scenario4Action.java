import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scenario4Action {
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

        //Click on "Sign In"
        WebElement menuBags = driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"));
        menuBags.click();

        //fill Email
        WebElement inputEmail = driver.findElement(By.xpath("//input[@name='login[username]']"));
        inputEmail.sendKeys("lehieuman13@gmail.com");

        //fill Password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='login[password]']"));
        inputPassword.sendKeys("1234567Abx");

        //Click Sign In
        WebElement signInBtn = driver.findElement(By.xpath("//button[@type='submit']//span[contains(text(),'Sign In')]"));
        signInBtn.click();

        //wait for form sent success
        //verify "Welcome, !"
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//li[@class='greet welcome']")),
                "Welcome,"));

        //add to card

        WebElement item = driver.findElement(By.xpath("//div[@class='product-item-details'][1]"));
        new Actions(driver).moveToElement(item).perform();
        WebElement addSize = driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@index='0']"));
        addSize.click();
        WebElement addColor = driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@index='0']"));
        addColor.click();
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='product-item-details'][1]//button[@type='submit']//span[contains(text(),'Add to Cart')]"));
        addToCart.click();
        wait.until(ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//span[@class='counter-number']")),
                "1"));
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
