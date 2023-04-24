import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scenario3Action {
    private WebDriver driver;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void verifyUrlContactUs() throws InterruptedException {
        driver.manage().window().maximize();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        //Click on "Contact Us"
        WebElement contactUs = driver.findElement(By.xpath("//footer[@class='page-footer']//a[contains(text(),'Contact Us')]"));
        contactUs.click();

        //Assert Equal to expect Url
        String expectUrl = "https://magento.softwaretestingboard.com/contact/";
        Assert.assertEquals(driver.getCurrentUrl(), expectUrl);

    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
