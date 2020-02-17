import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class checkTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aliciavalladares/Documents/Workspace/Drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testDocker() {
        driver.manage().window().getSize();
        driver.get("https://www.zara.com/es/en/");
        driver.findElement(By.linkText("LOG IN")).click();


        driver.findElement(By.id("email")).sendKeys("aligarvalladares@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Alicia7143");
        driver.findElement(By.id("login-button")).click();

        //assertEquals(3, driver.findElement(By.className("news-card")).getSize());

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}