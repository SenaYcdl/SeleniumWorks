package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev3_LoginTest {
    /*
    1. “https://www.saucedemo.com” Adresine gidin
2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin

     */

  WebDriver driver;

    @Before
     public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test(){

        //“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");


        //Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        //Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        driver.findElement(By.className("inventory_item_name")).click();

        //Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[text()='Add to cart']")).click();

        //Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();

        // Sectiginiz urunun basarili olarak sepete eklendigini control edin
        System.out.println(driver.findElement(By.className("cart_item_label")).isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
