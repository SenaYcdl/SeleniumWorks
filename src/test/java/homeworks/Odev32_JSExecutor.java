package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import utilities.TestBaseBeforeAfter;

public class Odev32_JSExecutor extends TestBaseBeforeAfter {

    /*
    Yeni bir class olusturun : ScroolInto
hotelmycamp anasayfasina gidin
2 farkli test method’u olusturarak actions classi ve
Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
istediginiz oda inceleme sayfasi acildigini test  edin
     */


    @Test
    public void action(){

        driver.get("https://hotelmycamp.com");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]")).click();

    }



    @Test
    public void JsExecutor(){


        driver.get("https://hotelmycamp.com");
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement room=driver.findElement(By.xpath("(//*[@class='btn-custom'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true);" ,room);
        js.executeScript("arguments[0].click();",room);

        //istediginiz oda inceleme sayfasi acildigini test  edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "dsafsaf";
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }





}
