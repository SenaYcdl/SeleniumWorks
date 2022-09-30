package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev2_NutellaArama {
    /*
    1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4-Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6-Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8-Sayfayi kapatin
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
    public void test1(){

       // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");


       // cookies uyarisini kabul ederek kapatin
        // Sayfa basliginin “Google” ifadesi icerdigini test edin
       String actualTitle=driver.getTitle();
       String expectedTitle="Google";
       String result=actualTitle.contains(expectedTitle) ? "Passed" : "Failed";
        System.out.println(result);


        // Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Nutella", Keys.ENTER);

        //Bulunan sonuc sayisini yazdirin
       // WebElement results= driver.findElement(By.id("result-stats"));
        //String get=results.getText();
       // String [] sonuc=get.split(" ");
        //Arrays.stream(sonuc).limit(2).skip(1).forEach(System.out::println);

        List<WebElement> aramaSonucu = driver.findElements(By.xpath("//*[@id='result-stats']"));
        String sonucYazisi = aramaSonucu.get(0).getText();
        System.out.println(sonucYazisi);

        String [] sonucYazisiE = sonucYazisi.split(" ");
        System.out.println("Nutella arama sonucu = "+sonucYazisiE[1]);


        // sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

       int sonuc1=Integer.parseInt(sonucYazisiE[1].replaceAll("\\D",""));
       if (sonuc1>100000000){
           System.out.println("Passed");
       } else System.out.println("Failed");

        driver.quit();


    }
}
