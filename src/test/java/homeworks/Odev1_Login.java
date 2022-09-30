package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev1_Login {
 /*
    Soru 1
            1. http://zero.webappsecurity.com sayfasina gidin
            2. Signin buttonuna tiklayin
3. Login alanine “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin
  */


    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test() {

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        // 3. Login alanine "username" yazdirin
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("username");

        //4. Password alanine "password" yazdirin
        driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='More Services']")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();


        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("1000");


        //8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.cssSelector("#sp_date")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin #pay_saved_payees
        driver.findElement(By.cssSelector("#pay_saved_payees")).click();

        //10. "The payment was successfully submitted." mesajinin ciktigini control edin
        System.out.println("The payment was successfully submitted  : " + driver.findElement
                (By.xpath("//*[text()='The payment was successfully submitted.']")).isDisplayed());
    }


    @After
    public void TearDown() {

        driver.close();
    }
}
