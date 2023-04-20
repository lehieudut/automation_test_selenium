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
        WebElement menuGear = driver.findElement(By.xpath("//a[@role='menuitem']//span[contains(text(),'Gear')]"));
        new Actions(driver).moveToElement(menuGear).perform();
        //Click on "Bags " menu
        WebElement menuBags = driver.findElement(By.xpath("//a[@role='menuitem']//span[contains(text(),'Bags')]"));
        menuBags.click();

        String expectedTitle = "Bags - Gear";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        driver.quit();
    }
}
