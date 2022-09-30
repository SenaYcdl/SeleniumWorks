package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev10DropDown {

    /*
    ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın
     */


    WebDriver driver;
    Select select;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {

        driver.quit();
    }


    @Test
    public void test() throws InterruptedException {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");


        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement drop1 = driver.findElement(By.xpath("//*[@id = 'dropdown']"));
        select = new Select(drop1);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        Thread.sleep(2000);

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement drop2 = driver.findElement(By.xpath("//*[@id = 'dropdown']"));
        select = new Select(drop2);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());


        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdown= select.getOptions();
        for (WebElement each: dropdown) {
            System.out.println(each.getText());

        }

        //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın

        int OptionsNumbers = select.getOptions().size();
        int expectedOptionsNumbers = 4;
        if (OptionsNumbers == expectedOptionsNumbers) {
            System.out.println("True");
        } else System.out.println("False");
    }

}