package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev17_Allert extends TestBaseBeforeAfter {

     /*
    ● Bir class olusturun: Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
“You successfully clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
     */

    //accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı.
    //driver.switchTo( ).alert( ).accept( );
    //● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
    //driver.switchTo( ).alert( ).dismiss( );
    //● getText() => Uyarıdaki(alert) mesajı almak için.
    //driver.switchTo( ).alert( ).getText( );
    //● sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
    //driver.switchTo( ).alert( ).sendKeys("Text")


    @Test
    public void test1() throws InterruptedException {


        //https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //“You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("You successfully clicked an alert"));




    }

    @Test
    public void test2(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        String actualMessage = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMessage = "successfuly";
        Assert.assertNotEquals(actualMessage,expectedMessage);



    }

    @Test
    public void test3() throws InterruptedException {

        //○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Sena");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You entered: Sena']")).isDisplayed());


        driver.close();

    }
}