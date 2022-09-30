package homeworks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class Odev18_Actions extends TestBaseBeforeAfter {

    /*
     Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
 2- Hover over Me First" kutusunun ustune gelin
Link 1" e tiklayin
Popup mesajini yazdirin
Popup'i tamam diyerek kapatin
“Click and hold" kutusuna basili tutun
7-“Click and hold" kutusunda cikan yaziyi yazdirin
8- “Double click me" butonunu cift tiklayin

     */


    @Test
    public void test() throws InterruptedException {


        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");


        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hover=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hover).perform();
        Thread.sleep(2000);


        //Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //Popup mesajini yazdirin
        System.out.println("Popup message: " + driver.switchTo().alert().getText());


        //Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //“Click and hold" kutusuna basili tutun
        WebElement clickHold= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.moveToElement(clickHold).perform();



        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold message: " + clickHold.getText());


        //8- “Double click me" butonunu cift tiklayin
       WebElement doubleClick=  driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick).perform();

    }

}





