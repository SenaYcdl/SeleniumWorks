package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class Odev14WindowHandle extends TestBaseBeforeAfter {


     /*
        1. Yeni bir class olusturun (TekrarTesti)
2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” oldugunu dogrulayin
3. Sayfa URL'sinin “youtube” içerdigini (contains) doğrulayın
4.Sayfa’nin window handle degerini String bir degiskene atayin
5. Daha sonra yeni pencerede Amazon sayfasina gidin https://www.amazon.com/
6. Youtube sayfasina geri donun
7.Ikinci acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
8.sayfalari kapatin
         */


    @Test
    public void test() {

        //2. Youtube web sayfasına gidin ve sayfa başlığının "youtube" oldugunu dogrulayin
        driver.get("https://www.youtube.com");
        Assert.assertFalse(driver.getTitle().contains("youtube"));


        //3. Sayfa URL'sinin "youtube" içerdigini (contains) doğrulayın
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));


        //4.Sayfa'nin window handle degerini String bir degiskene atayin
        String handle = driver.getWindowHandle();


        //5. Daha sonra yeni pencerede Amazon sayfasina gidin https://www.amazon.com/
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazon = driver.getWindowHandle();


        //6. Youtube sayfasina geri donun
        driver.switchTo().window(handle);


        //7.Ikinci acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazon);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));


        //8.sayfalari kapatin
        driver.quit();

    }
}