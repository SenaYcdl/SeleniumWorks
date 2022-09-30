package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev5_RadioButton {
    /*
    1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
- Cookies’i kabul edin
- “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin
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
    public void test() throws InterruptedException {

        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");


        //Cookies'i kabul edin
        //"Create an Account" button'una basin
        driver.findElement(By.xpath("//*[text()='Create New Account']")).click();


        //radio buttons" elementlerini locate edin
        WebElement kadin = driver.findElement(By.xpath("//*[text()='Female']"));
        WebElement erkek = driver.findElement(By.xpath("//*[text()='Male']"));
        WebElement ozel = driver.findElement(By.xpath("//*[text()='Custom']"));
        if (!kadin.isSelected()) {
            kadin.click();
            Thread.sleep(2000);
        }
    }


    @After
    public void tearDown() {
        driver.close();
    }
}
