import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class MailTest {
    //unit test
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aleksejsaronov/IdeaProjects/selWebdriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //full screen browser
    }

    @AfterMethod
    public void setDown() {

        driver.quit();
    }

    @Test
    public void TestPas() {
        driver.get("https://mail.avtotor.ru/webmail/");

        WebElement username = driver.findElement(By.xpath("//body/div[@id='content']/main[1]/form[1]/div[1]/div[1]/section[2]/label[1]/input[1]"));
        WebElement next_btn = driver.findElement(By.xpath("//body/div[@id='content']/main[1]/form[1]/div[1]/div[1]/section[3]/div[1]/button[1]"));

        username.sendKeys("sharonov");
        next_btn.click();

        WebElement password = driver.findElement(By.xpath("//body/div[@id='content']/main[1]/form[1]/div[1]/div[1]/section[3]/label[1]/input[1]"));
        WebElement next_btn2 = driver.findElement(By.xpath("//body/div[@id='content']/main[1]/form[1]/div[1]/div[1]/section[4]/div[1]/button[1]"));
        password.sendKeys("standard2901");
        next_btn2.click();

        WebElement search = driver.findElement(By.xpath("//input[@id='gui.frm_main.search.search#main']"));
        search.sendKeys("from:bmwgroup");
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER);

        //String expectedUrl = "https://mail.avtotor.ru/webmail/#sign-in-password";
        //String actualUrl = driver.getCurrentUrl();
        //Assert.assertEquals(expectedUrl, actualUrl);
    }

    /*
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
    */
}
