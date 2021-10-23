import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {
    //unit test
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksejsaronov/IdeaProjects/selWebdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //full screen browser
    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @Test
    public void TestPas() {
        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement forgotPassButton = driver.findElement(By.xpath("//body/main[1]/div[4]/section[1]/form[1]/div[1]/div[1]/div[1]/div[11]/div[1]/a[2]"));
        forgotPassButton.click();

        String expectedUrl = "https://www.browserstack.com/users/password/new";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    public void TestSel() {
        driver.get("https://www.browserstack.com/users/sign_in");

        WebElement username = driver.findElement(By.id("user_email_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement login = driver.findElement(By.id("user_submit"));

        username.sendKeys("abc@mail.com");
        password.sendKeys("your_password");
        login.click();

        String actualUrl = "https://www.browserstack.com/dashboard";
        String expectedUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
