package homeworks;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class Odev31_GetScreenShot extends TestBaseBeforeAfter {


    /*
    Yeni bir class olusturun : amazonNutellaSearch
1- amazon anasayfaya gidin
2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
3- Nutella icin arama yapin
4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
     */


    @Test
    public void test() throws IOException {


        //1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

        TakesScreenshot ts=(TakesScreenshot) driver;
        File allpage=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(allpage,new File("target/ekranGoruntusu/"+ tarih + "AllPage.jpeg"));


        //3- Nutella icin arama yapin
        WebElement nutella=driver.findElement(By.id("twotabsearchtextbox"));
        nutella.sendKeys("Nutella", Keys.ENTER);

        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin

       WebElement result= driver.findElement(By.xpath("//*[text()='Nutella']"));
       Assert.assertTrue(result.getText().contains("Nutella"));




        WebElement logoElement=driver.findElement(By.xpath("//*[@data-image-index='1']"));
        File logoImage=new File ("target/nutella/element.jpeg");
        File logoGecici=logoElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(logoGecici,logoImage);



    }

}

