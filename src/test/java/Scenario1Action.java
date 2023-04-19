import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Scenario1Action {

    public String baseUrl = "https://magento.softwaretestingboard.com";

    String driverPath = "C:\\Webdriver\\chromedriver.exe";
    public WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
    }

    @Test
    public void  verifyTitleBags() throws InterruptedException {

        driver.manage().window().maximize();
        driver.navigate().to(baseUrl);
        Thread.sleep(2000);

        //Hold mouse to "Gear" menu
        WebElement menuGear = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/ul/li[4]/a"));
        new Actions(driver).moveToElement(menuGear).perform();
        Thread.sleep(2000);
        //Click on "Bags " menu
        WebElement menuBags = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/nav/ul/li[4]/ul/li/a"));
        menuBags.click();
        Thread.sleep(2000);

        String expectedTitle = "Bags - Gear";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(2000);
        driver.quit();
    }
}
