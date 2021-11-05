import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private static String URL_GIT = "https://github.com/SergeiDemyanenko/PlatformaticaQA_03";

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize(); //full screen browser

    }

    @AfterMethod
    public void setDown() {
        driver.quit();
    }

    @Test
    public void TestCodeNotifications() {
        driver.get(URL_GIT);
        WebElement watch = driver.findElement(By.xpath("(//div[@id='repository-container-header']/div/ul/li/a[@href='/login?return_to=%2FSergeiDemyanenko%2FPlatformaticaQA_03'])[1]"));

        watch.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://github.com/login?return_to=%2FSergeiDemyanenko%2FPlatformaticaQA_03");
    }

    @Test
    public void TestFork() {
        driver.get(URL_GIT);
        WebElement watch = driver.findElement(By.xpath("(//div[@id='repository-container-header']/div/ul/li/a[@href='/login?return_to=%2FSergeiDemyanenko%2FPlatformaticaQA_03'])[2]"));

        watch.click();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://github.com/login?return_to=%2FSergeiDemyanenko%2FPlatformaticaQA_03");
    }

    @Ignore
    @Test
    public void TestIssuesTab() {
        driver.get(URL_GIT);
        WebElement issuesTab = driver.findElement(By.xpath("//a[@id='issues-tab']"));
        issuesTab.click();

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://github.com/SergeiDemyanenko/PlatformaticaQA_03/issues");
    }


    @Ignore
    @Test
    public void TestForgotPas() {
        driver.get("");
        WebElement forgotPassButton = driver.findElement(By.xpath("//div[@class='input-wrapper']/a[@class='forgot-password-link']"));
        forgotPassButton.click();

        String expectedUrl = "https://www.browserstack.com/users/password/new";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @Ignore
    @Test
    public void TestLogin() {
        driver.get("");
        WebElement username = driver.findElement(By.id("user_email_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement login = driver.findElement(By.id("user_submit"));

        username.sendKeys("abc@mail.com");
        password.sendKeys("your_password");
        login.click();

        WebElement error = driver.findElement(By.id("bs-alert-text-id"));

    }


}
