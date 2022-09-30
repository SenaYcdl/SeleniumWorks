package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev9AssertionsYanlisEmailTesti {
    /*
    1. Bir Class olusturalim YanlisEmailTesti
2. http://automationpractice.com/index.php sayfasina gidelim
3. Sign in butonuna basalim
4. Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */


    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" http://automationpractice.com/index.php");
    }



    @Test
    public void test(){
        //Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("snycdl.gmail", Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}
