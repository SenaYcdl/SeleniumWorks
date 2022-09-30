package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class Odev13WindowHandle extends TestBaseBeforeAfter {



     /*
      1.Yeni bir class olusturalim (Homework)
2. facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
oldugunu dogrulayin (verify)
3.Sayfa’nin window handle degerini String bir degiskene atayin
4.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin
5.yeni pencerede https://www.youtube.com/ sayfasina gidin.
6. Sayfa basliginin “youtube” icerdigini dogrulayin.
7.Ilk acilan sayfaya donun ve facebook sayfasina dondugunuzu test edin
8.sayfalari kapatin

         */


    @Test
    public void test() {


         //2. facebook sayfasina gidin ve sayfa basliginin (title) "facebook"
        //oldugunu dogrulayin (verify)
        driver.get("https://facebook.com");
        Assert.assertFalse(driver.getTitle().equals("facebook"));


        //3.Sayfa'nin window handle degerini String bir degiskene atayin
        String pageWindowHnadle = driver.getWindowHandle();


        //4.Sayfa URL'inin "facebook" kelimesi icerdigini dogrulayin
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));


        //5.yeni pencerede https://www.youtube.com/ sayfasina gidin.
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com/");


        //6. Sayfa basliginin "youtube" icerdigini dogrulayin.
        Assert.assertFalse(driver.getTitle().contains("youtube"));


        //7.Ilk acilan sayfaya donun ve facebook sayfasina dondugunuzu test edin
        driver.switchTo().window(pageWindowHnadle);
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));


        //8.sayfalari kapatin
        driver.quit();

    }


}
