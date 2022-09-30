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

public class Tekrar01 {

    /*
    Bir class oluşturun: DropDown
https://the-internet.herokuapp.com/dropdown adresine gidin.
Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
Tüm dropdown değerleri(value) yazdırın
Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın.
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
    public void test() {

        //https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement firstOption = driver.findElement(By.xpath("//*[@id = 'dropdown']"));
        select = new Select(firstOption);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement secondtOption = driver.findElement(By.xpath("//*[@id = 'dropdown']"));
        select = new Select(secondtOption);
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());


        //Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        //Tüm dropdown değerleri(value) yazdırın
        List<WebElement> liste=select.getOptions();
        for (WebElement each:liste){
            System.out.println(each.getText());
        }


        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //False yazdırın.
        int actualOptionsNumbers=select.getOptions().size();
        int expectedOptionsNumbers=4;

        if(actualOptionsNumbers==expectedOptionsNumbers){
            System.out.println("True");
        } else System.out.println("False");
    }
}