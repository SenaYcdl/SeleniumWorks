package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;
import java.util.ArrayList;
import java.util.List;
public class Odev26_WindowHandle extends TestBaseBeforeAfter {


    //1."http://webdriveruniversity.com/" adresine gidin
    //2."Login Portal" a  kadar asagi inin
    //3."Login Portal" a tiklayin
    // 4.Diger window'a gecin
    //5."username" ve  "password" kutularina deger yazdirin
    //6."login" butonuna basin
    //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    // 8.Ok diyerek Popup'i kapatin
    //Ilk sayfaya geri donun
    //Ilk sayfaya donuldugunu test edin


    @Test
    public void test() {

        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        //1.yol-->SendKEYS ile--

        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        //WebElement loginPortalWE = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        //2.yol-->JsE ile..
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        WebElement loginPortalWE = driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        jsE.executeScript("arguments[0].click", loginPortalWE);

        //3."Login Portal" a tiklayin
        loginPortalWE.click();

        // 4.Diger window'a gecin
        List<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));

        //5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Icardi");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("12345");

        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPoupYazi = "validation failed";
        String actualPoupYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedPoupYazi, actualPoupYazi);

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //Ilk sayfaya geri donun
        driver.switchTo().window(windowHandles.get(0));


        //Ilk sayfaya donuldugunu test edin
        Assert.assertTrue(loginPortalWE.isDisplayed());
    }
}
