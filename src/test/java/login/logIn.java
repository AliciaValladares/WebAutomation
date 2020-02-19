package login;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class logIn {
    public static WebDriver driver;
    String encodedPwd = "QWxpZ2FyNzE0Mw==";
    String encodedUser = "YWxpZ2FydmFsbGFkYXJlc0BnbWFpbC5jb20=";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/aliciavalladares/Documents/Workspace/Drivers/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testDocker() throws InterruptedException {
        driver.manage().window().getSize();
        driver.get("https://www.zara.com/es/en/");
        driver.findElement(By.linkText("LOG IN")).click();

        Thread.sleep(5000);
        driver.findElement(By.id("email")).sendKeys(decodeUser(encodedUser));
        driver.findElement(By.id("password")).sendKeys(decodePwd(encodedPwd));

        Thread.sleep(5000);
        driver.findElement(By.id("login-button")).click();

        //assertEquals(3, driver.findElement(By.className("news-card")).getSize());
    }

    private CharSequence decodeUser(String encodedUser) {
        byte[] decodedUser = Base64.decodeBase64(encodedUser);
        return new String(decodedUser);
    }

    private CharSequence decodePwd(String encodedPwd) {
        byte[] decodedPass = Base64.decodeBase64(encodedPwd);
        return new String(decodedPass);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }
}