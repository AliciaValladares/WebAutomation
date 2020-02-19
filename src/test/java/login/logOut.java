package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class logOut {
    public static WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aliciavalladares/Documents/Workspace/Drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().getSize();
        driver.get("https://www.zara.com/es/en/");
    }

    @Test
    public void logOut() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.linkText("Alicia")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log Out")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
